package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.GetItemAdapter;
import com.doubleslash.ddamiapp.adapter.LikeAdapter;
import com.doubleslash.ddamiapp.model.GetItem;
import com.doubleslash.ddamiapp.model.LikeVO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetItemFragment extends Fragment implements GetItemAdapter.OnItemClickListener {
    private RecyclerView get_itemRecycle;
    private GetItemAdapter getItemAdapter;
    private ArrayList<GetItem> getItemArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_get_item, container, false);

        get_itemRecycle = (RecyclerView) view.findViewById(R.id.like_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        get_itemRecycle.setLayoutManager(layoutManager);
        getItemAdapter = new GetItemAdapter(getActivity(), getItemArrayList); //getLikeList()
        getItemAdapter.setOnItemClickListener(this);
        get_itemRecycle.setAdapter(getItemAdapter);
        return view;
    }

    @Override
    public void onItemClick(View view, GetItem getItem) {

    }
}
