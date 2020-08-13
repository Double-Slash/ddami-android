package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.ShopMaterialItem;
import com.doubleslash.ddamiapp.viewholder.ShopMaterialViewHolder;
import com.doubleslash.ddamiapp.viewholder.ShopViewHolder;

import java.util.ArrayList;


public class ShopMaterialAdapter extends RecyclerView.Adapter<ShopMaterialViewHolder> {

    ArrayList<ShopMaterialItem> mData=null;
    private OnShopMaterialItemClickListener onItemClickListener;

    public ShopMaterialAdapter(ArrayList<ShopMaterialItem> data, OnShopMaterialItemClickListener itemClickListener) {
        mData=data;
        this.onItemClickListener=itemClickListener;
    }


    @NonNull
    @Override
    public ShopMaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_shop_second,parent,false);
        return new ShopMaterialViewHolder(mainView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopMaterialViewHolder holder, int position) {
        holder.adapt(mData.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
