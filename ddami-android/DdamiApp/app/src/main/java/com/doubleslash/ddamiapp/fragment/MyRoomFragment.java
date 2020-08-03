package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleslash.ddamiapp.R;
import com.google.android.material.tabs.TabLayout;

public class MyRoomFragment extends Fragment {
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        //Create tabs on TabLayout
        TabLayout.Tab tab = null;
        tab = tabLayout.newTab().setText("전체분야");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록1");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록2");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록3");
        tabLayout.addTab(tab);

        return view;
    }
}
