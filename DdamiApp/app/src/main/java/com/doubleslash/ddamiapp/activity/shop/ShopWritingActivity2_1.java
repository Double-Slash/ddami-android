package com.doubleslash.ddamiapp.activity.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment1;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment2;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment3;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment4;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment5;
import com.google.android.material.tabs.TabLayout;

public class ShopWritingActivity2_1 extends AppCompatActivity {

    TabLayout mTabLayout;

    private FragmentManager fragmentManager;
    private ShopListFragment1 fragment1;
    private ShopListFragment2 fragment2;
    private ShopListFragment3 fragment3;
    private ShopListFragment4 fragment4;
    private ShopListFragment5 fragment5;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shop_writing_activity2_1);


    }


}