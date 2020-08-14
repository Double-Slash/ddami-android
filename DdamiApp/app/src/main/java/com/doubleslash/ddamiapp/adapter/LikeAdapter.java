package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.viewholder.LikeViewHolder;

import java.util.ArrayList;

public class LikeAdapter extends RecyclerView.Adapter<LikeViewHolder> {


    private ArrayList<LikeItem> list_like;
    public OnLikeItemClickListener onLikeListItemClicked;

    public LikeAdapter(ArrayList<LikeItem> list_like, OnLikeItemClickListener itemViewClickListener) {
        this.list_like = list_like;
        this.onLikeListItemClicked = itemViewClickListener;
    }
//
//    public interface OnItemClickListener {
//        void onItemClick(LikeItem likeVO);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View likeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.likelist_item_cardview, parent, false);
        return new LikeViewHolder(likeView);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        holder.adapt(list_like.get(position),onLikeListItemClicked);
    }

    @Override
    public int getItemCount() {
        return list_like.size();
    }

}