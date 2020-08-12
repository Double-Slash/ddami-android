package com.doubleslash.ddamiapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.model.MyroomItem;
import com.squareup.picasso.Picasso;

public class MyroomHolder extends RecyclerView.ViewHolder {
    public MyroomHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.myroom_itemimage);

    public void adapt(MyroomItem item){
        Picasso.get().load(item.getImage()).fit().into(imageView);
    }
}
