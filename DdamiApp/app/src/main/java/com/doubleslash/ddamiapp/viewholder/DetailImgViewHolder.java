package com.doubleslash.ddamiapp.viewholder;

import android.annotation.SuppressLint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.DetailImgItem;
import com.doubleslash.ddamiapp.model.MainItem;
import com.squareup.picasso.Picasso;

public class DetailImgViewHolder extends RecyclerView.ViewHolder {

    public DetailImgViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.detail_img_item);

    @SuppressLint("SetTextI18n")
    public void adapt(DetailImgItem detailItem){

        Picasso.get().load(detailItem.getImage()).fit().into(imageView);
    }

}