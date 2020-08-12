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
import com.doubleslash.ddamiapp.model.MainItem;
import com.squareup.picasso.Picasso;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private ImageView imageView = itemView.findViewById(R.id.main_image);
    private TextView title = itemView.findViewById(R.id.main_title);
    private TextView nickname = itemView.findViewById(R.id.main_nickname);
    private ImageView userThumbnail = itemView.findViewById(R.id.author_thumbnail);
    private TextView view = itemView.findViewById(R.id.tv_view);
    private TextView like = itemView.findViewById(R.id.tv_like);

    @SuppressLint("SetTextI18n")
    public void adapt(MainItem mainItem){

        Picasso.get().load(mainItem.getImage()).fit().into(imageView);
        title.setText(mainItem.getTitle());
        nickname.setText(mainItem.getNickname());

        view.setText(Integer.toString(mainItem.getViewCount()));
        like.setText(Integer.toString(mainItem.getLikeCount()));

        userThumbnail.setBackground(new ShapeDrawable(new OvalShape()));
        userThumbnail.setClipToOutline(true);
        Picasso.get().load(mainItem.getThumbnail()).into(userThumbnail);
    }
}
