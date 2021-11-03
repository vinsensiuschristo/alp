package com.example.alp.api;

public interface APILoginModel {
    void login(String username, String password, APILoginListener listener);
}
