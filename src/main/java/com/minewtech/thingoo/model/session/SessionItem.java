package com.minewtech.thingoo.model.session;

import lombok.Data;

import java.util.List;

@Data
public class SessionItem {
    private String  token;
    private String  userId;
    private String  name;
    private String  email;
    private String  role;

    public void setUserId(Object uuid) {
        this.userId= (String) uuid;
    }

    public void setToken(String s) {
        this.token=s;
    }

    public void setName(Object name) {
        this.name= (String) name;
    }

    public void setEmail(Object email) {
        this.email= (String) email;
    }

    public void setRole(Object role) {
        this.role= (String) role;
    }
}
