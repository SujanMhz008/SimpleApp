package com.sujanmaharjan008.simpleapp.model;

import java.util.List;

public class UserLogin {
    static List<Users> usersList;
    boolean result = false;
    String username, password;

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        UserLogin.usersList = usersList;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean testUser(){
       if(getUsersList()!= null){
           for (int i = 0; i< getUsersList().size();i++){
               final Users users = getUsersList().get(i);
               if (username.equals(users.getUsername())&& password.equals(users.getPassword())){
                   result = true;
               }
               else{
                   result = false;
               }
           }
       }
        return result;
    }
}
