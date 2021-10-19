package com.example.alp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alp.R;
import com.example.alp.model.NotUploadedStandar;
import com.example.alp.model.UnfinishedStandar;
import com.example.alp.model.UploadedStandar;

import java.util.List;

public class UploadedStandarAdapter extends RecyclerView.Adapter<UploadedStandarAdapter.MyViewHolder> {

    Context context;
    List<UploadedStandar> uploadedStandarList;

    public UploadedStandarAdapter(Context context, List<UploadedStandar> uploadedStandarList) {
        this.context = context;
        this.uploadedStandarList = uploadedStandarList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.unfinished_item, parent, false);
        UploadedStandarAdapter.MyViewHolder myViewHolder = new UploadedStandarAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvidGallery.setText(uploadedStandarList.get(position).getIdGallery());
        holder.tvnamaGallery.setText(uploadedStandarList.get(position).getNamaGallery());
        holder.tvalamatGallery.setText(uploadedStandarList.get(position).getAlamatGallery());
        holder.tvkotaGallery.setText(uploadedStandarList.get(position).getKotaGallery());
    }

    @Override
    public int getItemCount() {
        return uploadedStandarList.size();
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
