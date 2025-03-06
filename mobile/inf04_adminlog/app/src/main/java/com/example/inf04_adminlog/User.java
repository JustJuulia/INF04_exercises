package com.example.inf04_adminlog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    String login;
    String passw;
    String name;
    String surname;
    Boolean admin;
    public User(String login, String passw, String name, String surname, Boolean admin){
        this.login = login;
        this.passw = passw;
        this.name = name;
        this.surname = surname;
        this.admin = admin;
    }
    public String getfullName(){
        String fullname = name + "   " + surname;
        return fullname;
    }

    public Map<String, String> getFullUser(){
        Map<String, String> full_user = new HashMap<>();
        full_user.put("login", login);
        full_user.put("password", passw);
        full_user.put("name", name);
        full_user.put("surname", surname);
        if(admin) {
            full_user.put("admin", "true");
        }
        else{
            full_user.put("admin", "false");
        }
        return full_user;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return passw;
    }
}
