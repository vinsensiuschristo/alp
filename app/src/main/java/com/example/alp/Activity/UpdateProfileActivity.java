package com.example.alp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.alp.R;

public class UpdateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        ImageButton iconButton = (ImageButton) findViewById(R.id.backIcon);
        Fragment fragment = new ProfileFragment();

        iconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(UpdateProfileActivity.this,ProfileFragment.class);
//                startActivity(intent);
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
                finish();
            }
        });




    }
}