package com.example.alp.ui.download;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alp.R;

public class ActivityDownload extends AppCompatActivity {

    Button btnDownload;
    TextView textView;
    ProgressDialog progressDialog;
    Handler handler = new Handler();
    int progress;
    ProgressBar progressBar;

    ListView listViewData;
    ArrayAdapter<String> adapter;
    String[] arrayPeliculas = {"Project Example 1","Project Example 2","Project Example 3","Project Example 4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        listViewData = findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arrayPeliculas);
        listViewData.setAdapter(adapter);

        btnDownload = findViewById(R.id.btn_download);
        progressBar = findViewById(R.id.progressBar);




        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ActivityDownload.this);
                //show dialog
                progressDialog.show();
                //set content view
                progressDialog.setContentView(R.layout.progress_dialog);
                //set transparent background
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );

//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        startProgress();
//                    }
//                });
//                thread.start();
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();
        if (id == R.id.btn_download){
            String  itemSelected = "Selected items: \n";
            for (int i=0;i<listViewData.getCount();i++){
                if (listViewData.isItemChecked(i)){
                    itemSelected += listViewData.getItemAtPosition(i) + "\n";
                }
            }
            Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void startProgress(){

        for (progress=0; progress <= 100; progress=progress+1){
            try {
                Thread.sleep(50);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(progress));
                }
            });
        }
    }

}