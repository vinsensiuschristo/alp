package com.example.alp.ui.detailproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.alp.R;
import com.example.alp.ui.map.MapFragment;
import com.example.alp.ui.notuploaded.NotuploadedFragment;
import com.example.alp.ui.uploaded.UploadedFragment;
import com.example.alp.ui.unfinished.UnfinishedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailProjectActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.map);

        //initialize fragment
        Fragment fragment = new MapFragment();

        //open fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map:
//                Toast.makeText(getApplicationContext(), "map ", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MapFragment()).commit();
                return true;
            case R.id.unfinished:
//                Toast.makeText(getApplicationContext(), "unfinished ", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UnfinishedFragment()).commit();
                return true;
            case R.id.notUpload:
//                Toast.makeText(getApplicationContext(), "notUpload ", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NotuploadedFragment()).commit();
                return true;
            case R.id.upload:
//                Toast.makeText(getApplicationContext(), "upload ", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UploadedFragment()).commit();
                return true;
        }
        return false;
    }
}