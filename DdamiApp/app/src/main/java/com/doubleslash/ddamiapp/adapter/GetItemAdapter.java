package com.doubleslash.ddamiapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.GetItem;
import com.doubleslash.ddamiapp.model.LikeVO;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class GetItemAdapter extends RecyclerView.Adapter<GetItemAdapter.ViewHolder>{


    private Context mContext;
    private ArrayList<GetItem> getItemArrayList;

    public GetItemAdapter.OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, GetItem getItem);
    }

    public void setOnItemClickListener(GetItemAdapter.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public GetItemAdapter(Context mContext, ArrayList<GetItem> getItemArrayList) {
        this.mContext = mContext;
        this.getItemArrayList = getItemArrayList;
    }

    @Override
    public GetItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.get_list_item, parent, false);
        return new GetItemAdapter.ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GetItem getItem = getItemArrayList.get(position);
/*
        Glide.with(mContext)
                .load(likeVO.getThumb())
                .thumbnail(0.5f)
                .into(holder.img_thumb);
*/
        holder.PieceName.setText(getItem.getPiece_name());
        holder.UserUniv.setText(getItem.getUser_univ());
        holder.PiecePrice.setText(getItem.getPiece_price());
        holder.PieceDate.setText(getItem.getPiece_date());
        //   holder.likeListImage.setImageResource(Integer.parseInt(likeVO.getImage()));
        //   holder.likeProfile.setImageResource(Integer.parseInt(likeVO.getProfile()));

        holder.getItemLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //작업물 상세로 이동
                mOnItemClickListener.onItemClick(v, getItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getItemArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout getItemLayout;
        private ImageView PieceImage;
        private TextView PieceName,UserUniv, PiecePrice, PieceDate, DealState;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View convertView) {
            super(convertView);

            getItemLayout = (LinearLayout) convertView.findViewById(R.id.get_item_listLayout);
            PieceImage = (RoundedImageView) convertView.findViewById(R.id.get_item_img);
            PieceName = (TextView) convertView.findViewById(R.id.piece_name);
            UserUniv = (TextView) convertView.findViewById(R.id.heart_piece);
            PiecePrice = (TextView) convertView.findViewById(R.id.piece_price);
            PieceDate = (TextView) convertView.findViewById(R.id.get_item_date);
            DealState = (TextView) convertView.findViewById(R.id.deal_state);
        }
    }
}

