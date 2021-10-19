package com.example.alp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alp.R;
import com.example.alp.model.NotUploadedStandar;

import java.util.List;

public class NotUploadedStandarAdapter extends RecyclerView.Adapter<NotUploadedStandarAdapter.MyViewHolder> {

    Context context;
    List<NotUploadedStandar> notUploadedStandarList;

    public NotUploadedStandarAdapter(Context context, List<NotUploadedStandar> notUploadedStandarList) {
        this.context = context;
        this.notUploadedStandarList = notUploadedStandarList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.notuploaded_item, parent, false);
        NotUploadedStandarAdapter.MyViewHolder myViewHolder = new NotUploadedStandarAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvidGallery.setText(notUploadedStandarList.get(position).getIdGallery());
        holder.tvnamaGallery.setText(notUploadedStandarList.get(position).getNamaGallery());
        holder.tvalamatGallery.setText(notUploadedStandarList.get(position).getAlamatGallery());
        holder.tvkotaGallery.setText(notUploadedStandarList.get(position).getKotaGallery());
    }

    @Override
    public int getItemCount() {
        return notUploadedStandarList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvidGallery;
        private TextView tvnamaGallery;
        private TextView tvalamatGallery;
        private TextView tvkotaGallery;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvidGallery = itemView.findViewById(R.id.idGallery);
            tvnamaGallery = itemView.findViewById(R.id.namaGallery);
            tvalamatGallery = itemView.findViewById(R.id.alamatGallery);
            tvkotaGallery = itemView.findViewById(R.id.kotaGallery);
        }
    }
}
