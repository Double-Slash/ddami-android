package com.doubleslash.ddamiapp.adapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.GetItem;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.viewholder.GetItemViewHolder;

import java.util.ArrayList;

public class GetItemAdapter extends RecyclerView.Adapter<GetItemViewHolder> {


    public GetItemAdapter(ArrayList<GetItem> getItemArrayList) {
        this.getItemArrayList = getItemArrayList;
    }

    private ArrayList<GetItem> getItemArrayList;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, GetItem getItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public GetItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View getItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_list_item, parent, false);
        return new GetItemViewHolder(getItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GetItemViewHolder holder, int position) {
        holder.adapt(getItemArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return getItemArrayList.size();
    }

}