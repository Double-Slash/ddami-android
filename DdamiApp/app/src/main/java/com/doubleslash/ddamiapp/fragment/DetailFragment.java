package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;

public class DetailFragment extends Fragment {
    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_detail, null);

        return view;
    }
}
