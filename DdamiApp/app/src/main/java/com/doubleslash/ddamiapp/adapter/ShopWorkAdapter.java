package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.viewholder.ShopViewHolder;

import java.util.ArrayList;


public class ShopWorkAdapter extends RecyclerView.Adapter<ShopViewHolder> {

    ArrayList<ShopWorkItem> mData=null;
    private OnShopItemClickListener onItemClickListener;

    public ShopWorkAdapter(ArrayList<ShopWorkItem> data, OnShopItemClickListener itemClickListener) {
        mData=data;
        this.onItemClickListener=itemClickListener;
    }


    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_shop_first,parent,false);
        return new ShopViewHolder(mainView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.adapt(mData.get(position), onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}
