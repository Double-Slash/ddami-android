package com.doubleslash.ddamiapp.viewholder;

import android.annotation.SuppressLint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.LikeAdapter;
import com.doubleslash.ddamiapp.model.DetailImgItem;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.squareup.picasso.Picasso;

public class LikeViewHolder extends RecyclerView.ViewHolder {

    public LikeViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private LinearLayout layoutLikeList = (LinearLayout)itemView.findViewById(R.id.layout_like_list);
    private ImageView likeListImage = (ImageView) itemView.findViewById(R.id.likelist_listImage);
    private ImageView likeProfile = (ImageView) itemView.findViewById(R.id.likelist_profile);
    private ImageButton heartPiece = (ImageButton) itemView.findViewById(R.id.heart_piece);
    private TextView likeNic = (TextView) itemView.findViewById(R.id.likelist_nic);
    private TextView title = (TextView) itemView.findViewById(R.id.title_piece);

    @SuppressLint("SetTextI18n")
    public void adapt(LikeItem likeItem){


        Picasso.get().load(likeItem.getImage()).fit().into(likeListImage);

        title.setText(likeItem.getTitle());
        likeNic.setText(likeItem.getNicname());
//        if(likeItem.getHeart()==true){
//            heartPiece.setSelected(true);
//        }else if(likeItem.getHeart()==false){
//            heartPiece.setSelected(false);
//        }

        likeProfile.setBackground(new ShapeDrawable(new OvalShape()));
        likeProfile.setClipToOutline(true);
        Picasso.get().load(likeItem.getProfile()).into(likeProfile);
    }
}