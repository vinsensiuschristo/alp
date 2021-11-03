package com.example.alp.model;

import android.app.Application;

import com.example.alp.api.APILoginListener;
import com.example.alp.api.APILoginModel;
import com.example.alp.api.LoginAPI;

public class LoginModel {

    private static LoginModel sInstance = null;
    private final APILoginModel mApi;
    private UserLoginModel mUser;

    public static LoginModel getInstance(Application application){
        if (sInstance == null){
            sInstance = new LoginModel(application);
        }
        return sInstance;
    }

    private final Application mApplication;

    public LoginModel(Application application){
        mApplication = application;
        mApi = new LoginAPI(mApplication);
    }

    public Application getmApplication(){
        return mApplication;
    }

    public void login(String username, String password, APILoginListener listener){
        mApi.login(username, password, listener);
    }

    public UserLoginModel getUser(){
        return mUser;
    }

    public void setUser(UserLoginModel user){
        this.mUser = user;
    }
}
