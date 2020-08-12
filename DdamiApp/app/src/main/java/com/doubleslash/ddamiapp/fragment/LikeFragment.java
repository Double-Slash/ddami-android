package com.doubleslash.ddamiapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.LikeAdapter;
import com.doubleslash.ddamiapp.adapter.MainAdapter;
import com.doubleslash.ddamiapp.model.LikeVO;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LikeFragment extends Fragment implements LikeAdapter.OnItemClickListener {

    Button likeBack;

    private RecyclerView like_recyclerview;
    private LikeAdapter mLikeAdapter;
    private ArrayList<LikeVO> list = new ArrayList<>(); //서버에서 불러오기

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static LikeFragment newInstance() {
        return new LikeFragment();
    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_like_list, container, false);

        //  likeBack = (Button) view.findViewById(R.id.like_back);


        JsonObject inputJson = new JsonObject();
        //likeByUser :Boolean 사용
        ApiService.INSTANCE.getDetailPieceService().getDeatil(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {



                            //comments
                            Log.e("tttest",it.toString());
                        },it -> {
                            Log.e("failed",it.toString());
                        });


        like_recyclerview = (RecyclerView) view.findViewById(R.id.like_recyclerview);

        mLikeAdapter = new LikeAdapter(getActivity(), list); //getLikeList()
        mLikeAdapter.setOnItemClickListener(this);

        like_recyclerview.setAdapter(mLikeAdapter);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        like_recyclerview.setLayoutManager(mLayoutManager);


        //작품 상세보기 likeByMe = true면 추가


        LikeVO item1 = new LikeVO("http://222.251.129.150/uploads/1597061667017.jpg", "타이틀1", "http://222.251.129.150/uploads/1597061667017.jpghttp://222.251.129.150/uploads/1597061667017.jpg","진희1");
        LikeVO item2 = new LikeVO("http://222.251.129.150/uploads/1597061667017.jpg", "타이틀2", "http://222.251.129.150/uploads/1597061667017.jpg","진희2");
        LikeVO item3 = new LikeVO("https://t1.daumcdn.net/cfile/tistory/2744FB4058719BE733", "타이틀3", "http://222.251.129.150/uploads/1597061667017.jpg","진희3");
        LikeVO item4 = new LikeVO("https://www.enewstoday.co.kr/news/photo/201805/1188725_303007_1317.jpg", "타이틀4", "http://222.251.129.150/uploads/1597061667017.jpg","진희4");

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);



        return view;
    }

    @Override
    public void onItemClick(View view, LikeVO likeVO) {
        //작품 상세보시로 이동, id값 같이
        Log.e("RecyclerVIew :: ", likeVO.toString());
    }


    /*
    private ArrayList<LikeVO> getLikeList() {
        ArrayList<LikeVO> likeList = new ArrayList<>();
        Gson gson = new Gson();

        try {
            //json파일??서버??
            InputStream is = getAssets().open("likelist.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("likelist");

            int index = 0;
            while (index < jsonArray.length()) {
                LikeVO likeVO = gson.fromJson(jsonArray.get(index).toString(), LikeVO.class);
                likeList.add(likeVO);

                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return likeList;
    }

     */

}



