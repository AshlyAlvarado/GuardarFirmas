package com.example.exercise_24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class signaturess extends RecyclerView.Adapter<signaturess.FirmaViewHolder> {

    private List<byte[]> firmasList;

    public signaturess(List<byte[]> firmasList) {
        this.firmasList = firmasList;
    }

    @NonNull
    @Override
    public signaturess.FirmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_signaturess, parent, false);
        return new FirmaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull signaturess.FirmaViewHolder holder, int position) {
        byte[] firma = firmasList.get(position);
        // Asigna la firma al ImageView del CardView
        holder.ivFirma.setImageBitmap(BitmapFactory.decodeByteArray(firma, 0, firma.length));
    }

    @Override
    public int getItemCount() {
        return firmasList.size();
    }

    public class FirmaViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivFirma;

        public FirmaViewHolder(View itemView) {
            super(itemView);
            ivFirma = itemView.findViewById(R.id.iv_firma);
        }
    }
}
