package com.example.alp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alp.api.AbstractAPILoginListener;
import com.example.alp.model.LoginModel;
import com.example.alp.model.UserLoginModel;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        TextInputLayout textInputLayout2 = findViewById(R.id.textInputLayout2);
        TextInputLayout textInputLayout3 = findViewById(R.id.textInputLayout3);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text2 = String.valueOf(textInputLayout2.getEditText().getText());
                String text3 = String.valueOf(textInputLayout3.getEditText().getText());


//                Toast.makeText(MainActivity.this,"Username : " + text2 + "\nPassword : " + text3, Toast.LENGTH_SHORT).show();


//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);

                LoginModel model = LoginModel.getInstance(MainActivity.this.getApplication());
                model.login(text2,text3, new AbstractAPILoginListener() {
                    @Override
                    public void onLogin(UserLoginModel user){
                        model.setUser(user);
                        Toast.makeText(MainActivity.this,"User + " + user.getMessage(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}