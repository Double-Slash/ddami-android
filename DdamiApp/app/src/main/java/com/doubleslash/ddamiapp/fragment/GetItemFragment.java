package com.doubleslash.ddamiapp.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.GetItemAdapter;
import com.doubleslash.ddamiapp.adapter.LikeAdapter;
import com.doubleslash.ddamiapp.model.GetItem;
import com.doubleslash.ddamiapp.model.GetItemDAO;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.model.LikeProduct;
import com.doubleslash.ddamiapp.model.MyLikeListItemDAO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetItemFragment extends Fragment implements GetItemAdapter.OnItemClickListener {

    ImageButton getItemBack;

    private RecyclerView get_itme_recycler;
    private GetItemAdapter mLikeAdapter;
    private ArrayList<GetItem> list = new ArrayList<>(); //서버에서 불러오기
    String token;

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static GetItemFragment newInstance() {
        return new GetItemFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        token = getActivity().getIntent().getStringExtra("token");

    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_get_item, container, false);

        getItemBack = (ImageButton) view.findViewById(R.id.get_item_back);

        getItemBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(GetItemFragment.this).commit();
                fragmentManager.popBackStack();
            }
        });


        Log.e("진희: token :", token);

        ApiService.INSTANCE.getGetItemApi().getLikeList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {

                            get_itme_recycler = (RecyclerView) view.findViewById(R.id.get_item_recyclerview);

                            for (int i = 0; i < it.getLikeProducts().size(); i++) {
                                LikeProduct like = it.getLikeProducts().get(i);
                                list.add(new GetItem(like.getFileUrl().get(0),
                                        like.getTitle(),
                                        //       like.getAuthor().getUserProfile(),
                                        like.get_id()));
                            }
                            mLikeAdapter = new GetItemAdapter(list);
                            mLikeAdapter.setOnItemClickListener(this);

                            get_itme_recycler.setAdapter(mLikeAdapter);

                            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
                            get_itme_recycler.setLayoutManager(mLayoutManager);


                            //작품 상세보기 likeByMe = true면 추가


//                            LikeItem item1 = new LikeItem("http://222.251.129.150/uploads/1597061667017.jpg", "타이틀1", "http://222.251.129.150/uploads/1597061667017.jpghttp://222.251.129.150/uploads/1597061667017.jpg","진희1");
//                            LikeItem item2 = new LikeItem("http://222.251.129.150/uploads/1597061667017.jpg", "타이틀2", "http://222.251.129.150/uploads/1597061667017.jpg","진희2");
//                            LikeItem item3 = new LikeItem("https://t1.daumcdn.net/cfile/tistory/2744FB4058719BE733", "타이틀3", "http://222.251.129.150/uploads/1597061667017.jpg","진희3");
//                            LikeItem item4 = new LikeItem("https://www.enewstoday.co.kr/news/photo/201805/1188725_303007_1317.jpg", "타이틀4", "http://222.251.129.150/uploads/1597061667017.jpg","진희4");
//
//                            list.add(item1);
//                            list.add(item2);
//                            list.add(item3);
//                            list.add(item4);
//


                            //comments
                            Log.e("tttest",it.toString());
                        },it -> {
                            Log.e("failed",it.toString());
                        });

        return view;
    }


    @Override
    public void onItemClick(View view, GetItem getItem) {
        Log.e("RecyclerVIew :: ", getItem.toString());

    }
}



