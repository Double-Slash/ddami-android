package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.viewholder.LikeViewHolder;

import java.util.ArrayList;

public class LikeAdapter extends RecyclerView.Adapter<LikeViewHolder> {


    public LikeAdapter(ArrayList<LikeItem> list_like) {
        this.list_like = list_like;
    }

    private ArrayList<LikeItem> list_like;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, LikeItem likeVO);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View likeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.likelist_item_cardview, parent, false);
        return new LikeViewHolder(likeView);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        holder.adapt(list_like.get(position));
//
//        holder.heartPiece.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                holder.heartPiece.setImageResource(R.drawable.btn_detailview_heart);
//            }
//        });
//        holder.layoutLikeList.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //작업물 상세로 이동
//                mOnItemClickListener.onItemClick(v, likeVO);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list_like.size();
    }

}