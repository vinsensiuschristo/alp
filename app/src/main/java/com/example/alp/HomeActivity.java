package com.example.alp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.alp.Data.ListItem;
import com.example.alp.Data.ListItemAdapter;
import com.example.alp.Data.ListItemData;
import com.example.alp.Activity.AboutFragment;
import com.example.alp.Activity.ActivityDownload;
import com.example.alp.Activity.DetailProjectActivity;
import com.example.alp.Activity.ProfileFragment;
import com.example.alp.Activity.ReportActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private RecyclerView rvHeroes;
    private ArrayList<ListItem> list = new ArrayList<>();
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        btnUpdate = findViewById(R.id.btnUpdate);

        list.addAll(ListItemData.getListData());
        showRecyclerList();

        NavigationView navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar,
                R.string.navigation_draw_open,
                R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //ubahWarnaNavigationDrawerMenu
//        NavigationView navigationView = findViewById(R.id.navigationView);
//        navigationView.setItemIconTintList(null);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuProfile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
            case R.id.menuAbout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutFragment()).commit();
                break;
            case R.id.home:
                Intent homeIntent = new Intent(this, HomeActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.menuDownload:
                Intent downloadIntent = new Intent(this, ActivityDownload.class);
                startActivity(downloadIntent);
                break;
            case R.id.menuReport:
                Intent reportIntent = new Intent(this, ReportActivity.class);
                startActivity(reportIntent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    //munculin recyclerList
    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListItemAdapter listItemAdapter = new ListItemAdapter(list);
        rvHeroes.setAdapter(listItemAdapter);

        listItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ListItem data) {
                Intent homeIntent = new Intent(getApplicationContext(), DetailProjectActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}