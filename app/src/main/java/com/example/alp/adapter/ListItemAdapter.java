package com.example.alp.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.alp.R;
import com.example.alp.model.ListItem;
import com.example.alp.ui.detailproject.DetailProjectActivity;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListViewHolder>{

    private OnItemClickCallback onItemClickCallback;
    private ArrayList<ListItem> listListItems;
    private Object MainActivity;

    public ListItemAdapter(ArrayList<ListItem> list) {
        this.listListItems = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        ListItem listItem = listListItems.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listItem.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(listItem.getName());
        holder.tvDetail.setText(listItem.getDetail());

        //dicoding
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), "Update " +
//                        listListItems.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                ////
//                showCustomDialog();
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.progress_bar_layout, null);

                ProgressBar progressBar;
                TextView textViewProgress;
                int progressBarStatus = 0;
                int i = 0;
                CountDownTimer mCountDownTimer;

                progressBar = dialogView.findViewById(R.id.progressBar);
                textViewProgress = dialogView.findViewById(R.id.progress);

//                Progress
//                progressBarStatus = progressBarStatus + 10;
//                progressBar.setProgress(progressBarStatus);
//                progressBar.setMax(100);
//
//                mCountDownTimer=new CountDownTimer(10000,1000) {
//
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        progressBar.setVisibility(View.VISIBLE);
//                        Log.v("Log_tag", "Tick of Progress"+ i + millisUntilFinished);
//                        i++;
//                        progressBar.setProgress((int) i*100/(5000/1000));
//                        textViewProgress.setText(progressBar.getProgress()+"%");
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        //Do what you want
//                        i++;
//                        progressBar.setProgress(100);
//                        progressBar.setVisibility(View.INVISIBLE);
//                        textViewProgress.setVisibility(View.INVISIBLE);
////                        showDialog();
//                        // set title dialog
//                        builder.setTitle("Notifikasi");
//
//                        // set pesan dari dialog
//                        builder
//                                .setMessage("Download Selesai")
//                                .setIcon(R.mipmap.ic_launcher)
//                                .setCancelable(false)
////                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog,int id) {
////                        // jika tombol diklik, maka akan menutup activity ini
////                        MainActivity.this.finish();
////                    }
////                })
//                                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        // jika tombol ini diklik, akan menutup dialog
//                                        // dan tidak terjadi apa2
//                                        dialog.cancel();
//                                    }
//                                });
//
//                        // membuat alert dialog dari builder
//                        AlertDialog alertDialog = builder.create();
//
//                        // menampilkan alert dialog
//                        alertDialog.show();
//
//                    }
//                };
//                mCountDownTimer.start();
////              Sampai Sini

                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();
            }
        });

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent detail
                v.getContext().startActivity(new Intent(v.getContext(), DetailProjectActivity.class));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listListItems.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listListItems.size();
    }

    //pengenalan
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnUpdate, btnDetail;
        ProgressDialog progressDialog;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ListItem data);
    }


//    private void showDialog(){
////        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
////                this);
//        AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
//
//        // set title dialog
//        builder.setTitle("Notifikasi");
//
//        // set pesan dari dialog
//        builder
//                .setMessage("Download Selesai")
//                .setIcon(R.mipmap.ic_launcher)
//                .setCancelable(false)
////                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog,int id) {
////                        // jika tombol diklik, maka akan menutup activity ini
////                        MainActivity.this.finish();
////                    }
////                })
//                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // jika tombol ini diklik, akan menutup dialog
//                        // dan tidak terjadi apa2
//                        dialog.cancel();
//                    }
//                });
//
//        // membuat alert dialog dari builder
//        AlertDialog alertDialog = builder.create();
//
//        // menampilkan alert dialog
//        alertDialog.show();
//    }
}

