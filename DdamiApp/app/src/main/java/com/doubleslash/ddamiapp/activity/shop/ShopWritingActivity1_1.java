package com.doubleslash.ddamiapp.activity.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment1;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment2;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment3;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment4;
import com.doubleslash.ddamiapp.fragment.shop.ShopListFragment5;

import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShopWritingActivity1_1 extends AppCompatActivity {

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

        setContentView(R.layout.activity_shop_writing_activity1_1);

        mTabLayout = (TabLayout) findViewById(R.id.layout_tab2);

        fragmentManager = getSupportFragmentManager();

        fragment1 = new ShopListFragment1();
        fragment2 = new ShopListFragment2();
        fragment3 = new ShopListFragment3();
        fragment4 = new ShopListFragment4();
        fragment5 = new ShopListFragment5();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.shop_frameLayout, fragment1).commitAllowingStateLoss();
        Log.e("피드_프래그먼트 시작", "ㅋㅋ");

        // 작품샵 피드 서버 연결
        //String token=getActivity().getIntent().getStringExtra("token");

        //getUserInfo(token);

        // 따미샵-글작성(작품샵 피드 선택): 탭 선택 이벤트
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = fragmentManager.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        transaction.replace(R.id.shop_frameLayout, fragment1).commitAllowingStateLoss();

                        break;
                    case 1:
                        transaction.replace(R.id.shop_frameLayout, fragment2).commitAllowingStateLoss();
                        break;
                    case 2:
                        transaction.replace(R.id.shop_frameLayout, fragment3).commitAllowingStateLoss();
                        break;
                    case 3:
                        transaction.replace(R.id.shop_frameLayout, fragment4).commitAllowingStateLoss();
                        break;
                    case 4:
                        transaction.replace(R.id.shop_frameLayout, fragment5).commitAllowingStateLoss();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @SuppressLint("CheckResult")
    private void getUserInfo(String token) {
        JsonObject inputJson = new JsonObject();

        inputJson.addProperty("token", token);
        Log.e("test",token);
        ApiService.INSTANCE.getHomeService().userAuth(inputJson).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {

                        }, it -> {
                            Log.e("failed", it.toString());
                        }
                );
    }



    // 따미샵-글작성(작품샵 피드 선택) 다음 버튼 이벤트 처리
    public void onClickNextBtn(View v){
        Intent intent=new Intent(ShopWritingActivity1_1.this,ShopWritingActivity1_2.class);
        startActivity(intent);
    }


}