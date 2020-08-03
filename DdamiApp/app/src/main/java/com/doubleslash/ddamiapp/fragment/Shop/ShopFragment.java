package com.doubleslash.ddamiapp.fragment.Shop;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;
import com.google.android.material.tabs.TabLayout;

// 따미샵-작품, 재료
public class ShopFragment extends Fragment {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    ShopViewpagerAdapter mShopViewpagerAdapter;
    View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_shop, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = (TabLayout) v.findViewById(R.id.layout_tab);

        mViewPager = (ViewPager) v.findViewById(R.id.viewpager);
        mShopViewpagerAdapter = new ShopViewpagerAdapter(getChildFragmentManager(), 2);
        mViewPager.setAdapter(mShopViewpagerAdapter);

        // // 따미샵-작품, 재료 탭 선택 이벤트
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setActionBarTitle("따미샵");

        }
    }
}
