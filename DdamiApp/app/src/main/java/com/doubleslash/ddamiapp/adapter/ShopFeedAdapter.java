package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.ShopFeedItem;
import com.doubleslash.ddamiapp.model.ShopMaterialItem;
import com.doubleslash.ddamiapp.viewholder.ShopFeedViewHolder;
import com.doubleslash.ddamiapp.viewholder.ShopMaterialViewHolder;

import java.util.ArrayList;


public class ShopFeedAdapter extends RecyclerView.Adapter<ShopFeedViewHolder> {

    ArrayList<ShopFeedItem> mData=null;
    private OnShopFeedItemClickListener onItemClickListener;

    public ShopFeedAdapter(ArrayList<ShopFeedItem> data, OnShopFeedItemClickListener itemClickListener) {
        mData=data;
        this.onItemClickListener=itemClickListener;
    }


    @NonNull
    @Override
    public ShopFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_shop_feed,parent,false);
        return new ShopFeedViewHolder(mainView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopFeedViewHolder holder, int position) {
        holder.adapt(mData.get(position), onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}
