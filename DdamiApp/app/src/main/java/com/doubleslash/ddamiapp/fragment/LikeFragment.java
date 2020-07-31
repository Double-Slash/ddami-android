package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;

import java.util.ArrayList;

public class LikeFragment extends Fragment implements LikeAdapter.OnItemClickListener {

    Button likeBack;

    private RecyclerView like_recyclerview;
    private LikeAdapter mLikeAdapter;
    private ArrayList<LikeVO> list = new ArrayList<>(); //서버에서 불러오기

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static LikeFragment newInstance() {
        return new LikeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_like_list, container, false);

        likeBack = (Button) view.findViewById(R.id.like_back);

        like_recyclerview = (RecyclerView) view.findViewById(R.id.like_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        like_recyclerview.setLayoutManager(mLayoutManager);
        mLikeAdapter = new LikeAdapter(getActivity(), list); //getLikeList()
        mLikeAdapter.setOnItemClickListener(this);
        
        like_recyclerview.setAdapter(mLikeAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, LikeVO likeVO) {
        Log.e("RecyclerVIew :: ", likeVO.toString());
    }
}
