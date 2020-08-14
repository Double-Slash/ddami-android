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
import com.doubleslash.ddamiapp.model.GetItem;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.model.User;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class GetItemViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout getItemLayout = (LinearLayout) itemView.findViewById(R.id.get_item_listLayout);
    private ImageView PieceImage = (ImageView)itemView.findViewById(R.id.get_item_img);
    private TextView PieceName = (TextView) itemView.findViewById(R.id.piece_name);
    private TextView UserUniv =  (TextView) itemView.findViewById(R.id.get_item_univ);
    private TextView PiecePrice = (TextView) itemView.findViewById(R.id.piece_price);
    private TextView PieceDate = (TextView) itemView.findViewById(R.id.get_item_date);
    private TextView DealState = (TextView) itemView.findViewById(R.id.deal_state);


    public GetItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @SuppressLint("SetTextI18n")
    public void adapt(GetItem getItem){


        Picasso.get().load(getItem.getImage()).fit().into(PieceImage);
        PieceName.setText(getItem.getPiece_name());
        PieceDate.setText(getItem.getPiece_date());
        UserUniv.setText(getItem.getUser_univ());
        PiecePrice.setText(getItem.getPiece_price());
        DealState.setText(getItem.getDeal_state());
//        if(likeItem.getHeart()==true){
//            heartPiece.setSelected(true);
//        }else if(likeItem.getHeart()==false){
//            heartPiece.setSelected(false);
//        }

    }
}