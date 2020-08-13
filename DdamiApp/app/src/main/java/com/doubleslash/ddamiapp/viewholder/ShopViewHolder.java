package com.doubleslash.ddamiapp.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.OnItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopItemClickListener;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.squareup.picasso.Picasso;

public class ShopViewHolder extends RecyclerView.ViewHolder {

    public ShopViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.iv_shop);
    private TextView work = itemView.findViewById(R.id.tv_work);
    private TextView univ = itemView.findViewById(R.id.tv_univ);
    private TextView price = itemView.findViewById(R.id.tv_price);
    private TextView views=itemView.findViewById(R.id.tv_views);
    private TextView like=itemView.findViewById(R.id.tv_like);

    public void adapt(ShopWorkItem shopWorkItem, OnShopItemClickListener clickListener){
        Picasso.get().load(shopWorkItem.getmImageArr().get(0)).fit().into(imageView);

        work.setText(shopWorkItem.getmWork());
        univ.setText(shopWorkItem.getmUniv());
        price.setText(shopWorkItem.getmPrice()+"원");
        views.setText(shopWorkItem.getmViews()+"");
        like.setText(shopWorkItem.getmLike()+"");

        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clickListener.onShopWorkClicked(shopWorkItem);
            }
        });
    }
}
