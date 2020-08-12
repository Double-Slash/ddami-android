package com.doubleslash.ddamiapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.LikeVO;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class LikeAdapter
        extends RecyclerView.Adapter<LikeAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<LikeVO> list_like;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, LikeVO likeVO);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public LikeAdapter(Context mContext, ArrayList<LikeVO> list_like) {
        this.mContext = mContext;
        this.list_like = list_like;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.likelist_item_cardview, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LikeVO likeVO = list_like.get(position);
/*
        Glide.with(mContext)
                .load(likeVO.getThumb())
                .thumbnail(0.5f)
                .into(holder.img_thumb);
*/
        holder.likeNic.setText(likeVO.getNicname());
        holder.titlePiece.setText(likeVO.getTitle());
        holder.likeListImage.setImageURI(Uri.parse(likeVO.getImage()));
        holder.likeProfile.setImageURI(Uri.parse(likeVO.getProfile()));
        holder.heartPiece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //하트 누리면 빈하트 -> 좋아요 목록에서 없어짐    likeByUser = false

                holder.heartPiece.setImageResource(R.drawable.btn_detailview_heart);
            }
        });
        holder.layoutLikeList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //작업물 상세로 이동
                mOnItemClickListener.onItemClick(v, likeVO);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_like.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutLikeList;
        private ImageView likeListImage;
        private ImageView likeProfile;
        private ImageButton heartPiece;
        private TextView likeNic, titlePiece;

        public ViewHolder(View convertView) {
            super(convertView);

            layoutLikeList = (LinearLayout) convertView.findViewById(R.id.layout_like_list);
            likeListImage = (ImageView) convertView.findViewById(R.id.likelist_listImage);
            likeProfile = (ImageView) convertView.findViewById(R.id.likelist_profile);
            heartPiece = (ImageButton) convertView.findViewById(R.id.heart_piece);
            likeNic = (TextView) convertView.findViewById(R.id.likelist_nic);
            titlePiece = (TextView) convertView.findViewById(R.id.title_piece);
        }
    }

}