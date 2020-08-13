package com.doubleslash.ddamiapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.OnShopItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopMaterialItemClickListener;
import com.doubleslash.ddamiapp.model.ShopMaterialItem;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.squareup.picasso.Picasso;

public class ShopMaterialViewHolder extends RecyclerView.ViewHolder {

    public ShopMaterialViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.iv_material);
    private TextView material = itemView.findViewById(R.id.tv_material);
    private TextView materialTag=itemView.findViewById(R.id.tv_material_tag);
    private TextView univ = itemView.findViewById(R.id.tv_material_univ);
    private TextView price = itemView.findViewById(R.id.tv_material_price);
    private TextView views=itemView.findViewById(R.id.tv_material_views);
    private TextView like=itemView.findViewById(R.id.tv_material_like);

    public void adapt(ShopMaterialItem shopMaterialItem, OnShopMaterialItemClickListener clickListener){
        Picasso.get().load(shopMaterialItem.getmImageArr().get(0)).fit().into(imageView);

        material.setText(shopMaterialItem.getmMaterial());

        materialTag.setText(shopMaterialItem.getMaterialTag());

        univ.setText(shopMaterialItem.getmUniv());
        price.setText(shopMaterialItem.getmPrice()+"원");
        views.setText(shopMaterialItem.getmViews()+"");
        like.setText(shopMaterialItem.getmLike()+"");

        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clickListener.onShopMaterialClicked(shopMaterialItem);
            }
        });
    }
}
