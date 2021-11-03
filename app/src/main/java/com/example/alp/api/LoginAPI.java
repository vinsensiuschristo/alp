package com.example.alp.api;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.alp.HomeActivity;
import com.example.alp.MainActivity;
import com.example.alp.model.UserLoginModel;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginAPI implements APILoginModel{

    public static final String BASE_URL = "http://127.0.0.1:2222/api/login";
    private final Application mApplication;

    private RequestQueue mRequestQueue;

    public LoginAPI(Application application){
        mApplication = application;
        mRequestQueue = Volley.newRequestQueue(application);
    }

    public void login(String username, String password, final APILoginListener listener){
        String url = "http://192.168.1.106:2222/api/login";
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username",username);
            jsonObject.put("password",password);

            /////////

            Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        UserLoginModel user = UserLoginModel.getUser(response);
                        listener.onLogin(user);

//                        mModel.setUser(user);
//                        Toast.makeText(mApplication,"User token" + user.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        Toast.makeText(mApplication,"JSON exception", Toast.LENGTH_SHORT).show();
                        Log.e("eror",e.getMessage());
                    }

                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(mApplication,"Usename atau Passowrd Salah", Toast.LENGTH_SHORT).show();
//                    Log.e("request login",error.getMessage());
                }
            };

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject, successListener,errorListener);
            mRequestQueue.add(request);

//            if (request == null){
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }

        } catch (JSONException e) {
            Toast.makeText(mApplication,"JSON Exception", Toast.LENGTH_SHORT).show();
        }
    }

}
