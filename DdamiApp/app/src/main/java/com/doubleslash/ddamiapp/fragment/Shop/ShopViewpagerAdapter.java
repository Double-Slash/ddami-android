package com.doubleslash.ddamiapp.fragment.Shop;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


// 따미샵-작품, 재료 뷰페이저 어댑터
public class ShopViewpagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    ShopFirstFragment mTab1;

    public ShopViewpagerAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("@@", String.valueOf(position));
        switch (position) {
            case 0:
//                mTab1 = new ShopFirstFragment();
                return new ShopFirstFragment();
            case 1:
//                ShopSecondFragment tab2 = new ShopSecondFragment();
                return new ShopSecondFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
