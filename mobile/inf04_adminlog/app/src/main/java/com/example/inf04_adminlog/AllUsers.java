package com.example.inf04_adminlog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllUsers {
    private static AllUsers instance;
    private List<User> users = new ArrayList<>();
    public static AllUsers getInstance(){
        if(instance ==  null){
            instance = new AllUsers();
        }
        return instance;
    }
    public void addUser(User user) {
        users.add(user);
    }

    public User login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
