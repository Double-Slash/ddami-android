package com.doubleslash.ddamiapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.OnShopFeedItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopMaterialItemClickListener;
import com.doubleslash.ddamiapp.model.ShopFeedItem;
import com.doubleslash.ddamiapp.model.ShopMaterialItem;
import com.squareup.picasso.Picasso;

public class ShopFeedViewHolder extends RecyclerView.ViewHolder {

    public ShopFeedViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.iv_shop_feed);

    public void adapt(ShopFeedItem shopFeedItem, OnShopFeedItemClickListener clickListener){
        Picasso.get().load(shopFeedItem.getmImageArr().get(0)).fit().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clickListener.onShopFeedClicked(shopFeedItem);
            }
        });
    }
}
