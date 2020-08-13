package com.doubleslash.ddamiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.MyroomItem;
import com.doubleslash.ddamiapp.viewholder.MyroomHolder;

import java.util.ArrayList;

public class MyroomAdapter extends RecyclerView.Adapter<MyroomHolder> {
    private ArrayList<MyroomItem> items;

    public MyroomAdapter(ArrayList<MyroomItem> items) {
        this.items = items;
    }

    @Override
    public MyroomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myroom, parent, false);
        return new MyroomHolder(mainView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyroomHolder holder, int position) {
        holder.adapt(items.get(position));
    }
}