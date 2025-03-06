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
    public void delteUser(String login){
        for(User user: users){
            if(user.getLogin().equals(login)){
                users.remove(user);
            }
        }
    }
    public User login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public void changeUser(String login, String password, String name, String surname, Boolean isAdmin){
        for(User user : users){
            if((user.getLogin().equals(login)) || (user.name.equals(name) && user.surname.equals(surname))){
                users.remove(user);
                User my_changed = new User(login, password, name, surname,isAdmin);
                users.add(my_changed);
                break;
            }
        }
    }
    public void changeTheUser(String password){
        for(User user : users){
            if(user.getLogin().equals("admin")){
                users.remove(user);
                User my_changed = new User("admin", password, "Admin", "User",true);
                users.add(my_changed);
                break;
            }
        }
    }
    public List<User> getAllUsers() {
        return users;
    }
}
