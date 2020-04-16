package com.minewtech.thingoo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.minewtech.thingoo.identity.TokenUser;
import com.minewtech.thingoo.identity.TokenUtil;
import com.minewtech.thingoo.model.session.SessionItem;
import com.minewtech.thingoo.model.session.SessionResponse;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateTokenForUserFilterTest {

@Mock
    TokenUtil tokenUtil;
    GenerateTokenForUserFilter generateTokenForUserFilter;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpServletRequest req;
    HttpServletResponse res;
    FilterChain chain;
    Authentication authToken;
    AuthenticationManager authenticationManager;
    TokenUser tokenUser;
    SessionResponse resp;
    SessionItem respItem;



    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    @Test
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException{
        try{
            String jsonString = IOUtils.toString(request.getInputStream(), "UTF-8");
            /* using org.json */
            JSONObject userJSON;
            userJSON = new JSONObject(jsonString);
            String username = userJSON.getString("username");
            String password = userJSON.getString("password");
            //  log.info("username:{} and password:{} \n", username, password);
            //final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken("demo", "demo");
            final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
            return getAuthenticationManager().authenticate(authToken); // This will take to successfulAuthentication or faliureAuthentication function
        }
        catch( JSONException | AuthenticationException e){
            throw new AuthenticationServiceException(e.getMessage());
        }
    }

    @Test
    protected void successfulAuthentication() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String tokenString = this.tokenUtil.createTokenForUser(tokenUser);
        respItem.setName(tokenUser.getUser().getName());
        respItem.setUserId(tokenUser.getUser().getUuid());
        respItem.setEmail(tokenUser.getUser().getEmail());
        respItem.setRole(tokenUser.getUser().getRole().toString());
        respItem.setToken(tokenString);

        resp.setStatus(200);
        resp.setMessage("Login Success");
        resp.setData(respItem);
        String jsonRespString = ow.writeValueAsString(resp);
        res.setStatus(HttpServletResponse.SC_OK);
        try {
            res.getWriter().write(jsonRespString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(resp);
        Assert.assertNotNull(respItem);
    }



}