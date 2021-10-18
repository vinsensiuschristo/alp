package com.example.alp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alp.R;
import com.example.alp.model.UnfinishedStandar;

import java.util.List;

public class UnfinishedStandarAdapter extends RecyclerView.Adapter<UnfinishedStandarAdapter.MyViewHolder> {

    Context context;
    List<UnfinishedStandar> unfinishedStandarList;

    public UnfinishedStandarAdapter(Context context, List<UnfinishedStandar> unfinishedStandarList) {
        this.context = context;
        this.unfinishedStandarList = unfinishedStandarList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.unfinished_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvidGallery.setText(unfinishedStandarList.get(position).getIdGallery());
        holder.tvnamaGallery.setText(unfinishedStandarList.get(position).getNamaGallery());
        holder.tvalamatGallery.setText(unfinishedStandarList.get(position).getAlamatGallery());
        holder.tvkotaGallery.setText(unfinishedStandarList.get(position).getKotaGallery());
    }

    @Override
    public int getItemCount() {
        return unfinishedStandarList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

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
