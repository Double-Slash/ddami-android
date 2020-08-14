package com.doubleslash.ddamiapp.fragment.shop;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.ShopFeedAdapter;
import com.doubleslash.ddamiapp.adapter.ShopWorkAdapter;
import com.doubleslash.ddamiapp.model.MypieceX;
import com.doubleslash.ddamiapp.model.Product;
import com.doubleslash.ddamiapp.model.ShopFeedItem;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShopListFragment1 extends Fragment {

    ArrayList<ShopFeedItem> mData=null;
    RecyclerView.Adapter mAdapter=null;
    RecyclerView recyclerView=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_shop_list1, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("피드_프래그먼트 시작해서 여기까지 옴", "ㅋㅋ");
        recyclerView = view.findViewById(R.id.shop_feed_recyclerview);
        mData = new ArrayList<ShopFeedItem>();


        // 따미샵 - 작품샵 글작성- 서버연결
        //JsonObject input = new JsonObject();

        JsonObject inputJson = new JsonObject();

        String token=getActivity().getIntent().getStringExtra("token");

        Log.e("피드_토큰 확인",token);

        inputJson.addProperty("token", token);


        ApiService.INSTANCE.getShopFeedService().shopFeed(token,inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            //Toast.makeText(getContext(), "서버 연결 성공"+it.getMypieces().get(0).get_id(), Toast.LENGTH_SHORT).show();
                            //Log.e("서버 연결 확인_피드",it.getMypieces().get(0).getFileUrl().toString());
                            Log.e("이미지", it.getMypieces().get(0).getFileUrl().toString());
                            for(int i = 0; i<it.getMypieces().size(); i++){
                                MypieceX mypieceX = it.getMypieces().get(i);
                                mData.add(new ShopFeedItem(mypieceX.getFileUrl(), mypieceX.getState()));
                            }

                            mAdapter = new ShopFeedAdapter(mData,this::onShopFeedClicked);
                            recyclerView.setAdapter(mAdapter);

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
                            recyclerView.setLayoutManager(gridLayoutManager);

                        }, it -> {
                            //Toast.makeText(context, "서버 연결 실패", Toast.LENGTH_SHORT).show();


                        });

    }

    private void onShopFeedClicked(ShopFeedItem shopFeedItem) {
        Toast.makeText(getContext(), shopFeedItem.getmImageArr().get(0), Toast.LENGTH_LONG).show();
    }
}