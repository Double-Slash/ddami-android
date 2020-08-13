package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.DetailImgItem;
import com.doubleslash.ddamiapp.viewholder.DetailImgViewHolder;
import com.doubleslash.ddamiapp.viewholder.MainViewHolder;

import java.util.ArrayList;

public class DetailImgAdapter extends RecyclerView.Adapter<DetailImgViewHolder> {
    private ArrayList<DetailImgItem> imgs;

    public DetailImgAdapter(ArrayList<DetailImgItem> imgs) {
        this.imgs = imgs;
    }

    @NonNull
    public DetailImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View detailView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_img_item,parent,false);
        return new DetailImgViewHolder(detailView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailImgViewHolder holder, int position) {
        holder.adapt(imgs.get(position));
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }
}
