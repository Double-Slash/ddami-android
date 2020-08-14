package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.viewholder.MainViewHolder;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<MainItem> items;
    private OnItemClickListener onItemViewClickListener;
    private OnItemClickListener onItemProfileClickListener;

    public MainAdapter(ArrayList<MainItem> items,OnItemClickListener itemViewClickListener,OnItemClickListener itemProfileClickListener) {
        this.items = items;
        this.onItemViewClickListener = itemViewClickListener;
        this.onItemProfileClickListener = itemProfileClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_main, parent, false);
        return new MainViewHolder(mainView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.adapt(items.get(position), onItemViewClickListener,onItemProfileClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
