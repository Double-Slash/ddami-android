package com.doubleslash.ddamiapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.LikeAdapter;
import com.doubleslash.ddamiapp.model.LikeItem;
import com.doubleslash.ddamiapp.model.MyLikeListItemDAO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LikeFragment extends Fragment implements LikeAdapter.OnItemClickListener {

    ImageButton likeBack;

    private RecyclerView like_recyclerview;
    private LikeAdapter mLikeAdapter;
    private ArrayList<LikeItem> list = new ArrayList<>(); //서버에서 불러오기

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static LikeFragment newInstance() {
        return new LikeFragment();
    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_like_list, container, false);

        likeBack = (ImageButton) view.findViewById(R.id.like_back);

        likeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(LikeFragment.this).commit();
                fragmentManager.popBackStack();
            }
        });


        JsonObject inputJson = new JsonObject();
        ApiService.INSTANCE.getLikeList().getLikeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {

                            like_recyclerview = (RecyclerView) view.findViewById(R.id.like_recyclerview);

                            for (int i = 0; i < it.getLikes().size(); i++) {
                                MyLikeListItemDAO like = it.getLikes().get(i);
                                list.add(new LikeItem(like.getFileUrl().get(0),
                                        like.getTitle(),
                                 //       like.getAuthor().getUserProfile(),
                                        like.getAuthor().getUserId()));
                            }
                            mLikeAdapter = new LikeAdapter(list);
                            mLikeAdapter.setOnItemClickListener(this);

                            like_recyclerview.setAdapter(mLikeAdapter);

                            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
                            like_recyclerview.setLayoutManager(mLayoutManager);


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
    public void onItemClick(View view, LikeItem likeVO) {
        //작품 상세보시로 이동, id값 같이
        Log.e("RecyclerVIew :: ", likeVO.toString());
    }

}



