package com.example.alp.model;

import org.json.JSONException;
import org.json.JSONObject;

public class UserLoginModel {
    public static UserLoginModel getUser(JSONObject jsonObject) throws JSONException{

        String message = jsonObject.getString("message");
        JSONObject result = jsonObject.getJSONObject("result");
        String token = result.getString("token");

        UserLoginModel user = new UserLoginModel("username","name",token,message);
        return user;
    }

    private String username;
    private String name;
    private String token;
    private String message;

    public UserLoginModel(String username, String name, String token, String message) {
        this.username = username;
        this.name = name;
        this.token = token;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object obj){
        boolean result = false;

        if (obj != null && obj instanceof UserLoginModel){
            UserLoginModel that = (UserLoginModel) obj;
            if (this.username.equalsIgnoreCase(that.username)){
                return true;
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return this.username + "(" + this.username + ")";
    }
}
