package com.minewtech.thingoo;

import com.minewtech.thingoo.api.Email.RegisterValidateService;
import com.minewtech.thingoo.model.operation.Operation;
import com.minewtech.thingoo.model.session.SessionItem;
import com.minewtech.thingoo.model.session.SessionResponse;
import com.minewtech.thingoo.model.user.Role;
import com.minewtech.thingoo.model.Success;
import com.minewtech.thingoo.repository.OperationRepository;
import com.minewtech.thingoo.model.user.User;
import com.minewtech.thingoo.repository.UserRepository;
import com.minewtech.thingoo.api.SessionController;
import com.minewtech.thingoo.api.Email.SendEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Dem {
        @Autowired
        public UserRepository userRepository;
        public SessionController sessionController;

   private OperationRepository operationRepository;
        @Test
        public  void index(){
            Operation operation=new Operation();
            operation.setGateway_mac("AC233FC0000D");
            operation.setCreatedAt(new Date(System.currentTimeMillis()));
            operation.setUpdatedAt(new Date(System.currentTimeMillis()));
            operation.setOperation("root");

            Operation operation1=operationRepository.save(operation);
            System.out.println(operation1);

            User user1=new User();
            user1.uuid="1234";
            user1.name="demoUser";
            user1.email="demoUser1@gmail.com";
            user1.password="1234";
            user1.role=Role.ADMIN;

            System.out.println(user1.name);

            Success success=new Success();
            success.setCode("1234");
            success.setMessage("Try Demo");
            success.setRequestId("1234");

            System.out.println(success.toString());
            userRepository.save(new User(UUID.randomUUID().toString().replace("-", ""),"admin@beaconyun.com", "admin", "admin", Role.ADMIN, ""));

            SessionItem sessionItem = new SessionItem();
            SessionResponse resp = new SessionResponse();
            sessionItem.setToken("xxx.xxx.xxx");
            sessionItem.setUserId(user1.getUuid());
            sessionItem.setName(user1.getName());
            sessionItem.setEmail(user1.getEmail());
            //sessionItem.setRole(user.getRole());

            resp.setStatus(200);
            resp.setMessage("Dummy Login Success");
            resp.setData(sessionItem);

        }

        @Test
    public  void indes(){
          RegisterValidateService.processregister("jiayouxxt@gmail.com");

        }
        @Test
    public void initialUser(){
        User user1=new User();
        user1.uuid="1234";
        user1.name="demoUser";
        user1.email="demoUser1@gmail.com";
        user1.password="1234";
        user1.role=Role.ADMIN;

        System.out.println(user1.name);

        Success success=new Success();
        success.setCode("1234");
        success.setMessage("Try Demo");
        success.setRequestId("1234");

        System.out.println(success.toString());
        userRepository.save(new User(UUID.randomUUID().toString().replace("-", ""),"admin@beaconyun.com", "admin", "admin", Role.ADMIN, ""));

        SessionItem sessionItem = new SessionItem();
        SessionResponse resp = new SessionResponse();
        sessionItem.setToken("123.456.789");
        sessionItem.setUserId(user1.getUuid());
        sessionItem.setName(user1.getName());
        sessionItem.setEmail(user1.getEmail());
        sessionItem.setRole(user1.getRole());

        resp.setStatus(200);
        resp.setMessage("Dummy Login Success");
        resp.setData(sessionItem);
    }

    @Test
    public  void trialSend() throws GeneralSecurityException, MessagingException {
        SendEmail.send("aykutmayali@gmail.com","demo content");

    }


}
