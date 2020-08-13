package com.doubleslash.ddamiapp.fragment.shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doubleslash.ddamiapp.R;

import com.doubleslash.ddamiapp.activity.shop.ShopWritingActivity2_1;
import com.doubleslash.ddamiapp.adapter.OnShopItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopMaterialItemClickListener;
import com.doubleslash.ddamiapp.adapter.ShopMaterialAdapter;
import com.doubleslash.ddamiapp.adapter.ShopWorkAdapter;
import com.doubleslash.ddamiapp.model.Product;
import com.doubleslash.ddamiapp.model.ProductX;
import com.doubleslash.ddamiapp.model.ShopMaterialItem;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ShopSecondFragment extends Fragment implements OnShopMaterialItemClickListener {

    // 따미샵-작품샵 배열
    ArrayList<ShopMaterialItem> mData=null;
    RecyclerView.Adapter mAdapter=null;
    RecyclerView recyclerView=null;

    Context context;
    static ShopMaterialItem shopMaterialItem;


    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.shop_second_recyclerview);
        mData = new ArrayList<ShopMaterialItem>();

        //ShopWorkItem work1 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");
        //ShopWorkItem work2 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");
        //ShopWorkItem work3 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");
        //ShopWorkItem work4 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");
        //ShopWorkItem work5 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");
        //ShopWorkItem work6 = new ShopWorkItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800", "작품 이름 (한 줄만 표시해주세요)", "대학교 이름", "가격");

        //mData.add(work1);
        //mData.add(work2);
        //mData.add(work3);
        //mData.add(work4);
        //mData.add(work5);
        //mData.add(work6);


        // 따미샵 - 작품샵 - 서버연결
        JsonObject input = new JsonObject();
        ApiService.INSTANCE.getShopMaterialService().shopMaterial(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            //Toast.makeText(context, "서버 연결 성공"+it.getProducts().get(0).get_id(), Toast.LENGTH_SHORT).show();
                            Log.e("서버 연결 확인",it.getProducts().get(0).getFileUrl().toString());

                            for(int i = 0; i<it.getProducts().size(); i++){
                                ProductX productx = it.getProducts().get(i);
                                String tag="판매";
                                if(productx.getPrice()==0){
                                    tag="나눔";
                                }
                                mData.add(new ShopMaterialItem(productx.getFileUrl(), tag, productx.getTitle(), productx.getLocationName(), productx.getPrice(), productx.getViews(), productx.getLikeCount()));
                            }

                            mAdapter = new ShopMaterialAdapter(mData,this::onShopMaterialClicked);
                            recyclerView.setAdapter(mAdapter);

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
                            recyclerView.setLayoutManager(gridLayoutManager);

                        }, it -> {
                            Toast.makeText(context, "서버 연결 실패", Toast.LENGTH_SHORT).show();

                        });
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // 따미샵-재료: 플로팅버튼 이벤트처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_shop_second, container, false);
        FloatingActionButton btn = v.findViewById(R.id.floatingBtn_2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), ShopWritingActivity2_1.class));
            }
        });

        return v;

    }


    @Override
    public void onShopMaterialClicked(ShopMaterialItem shopMaterialItem) {
        Toast.makeText(getContext(), shopMaterialItem.getmMaterial(), Toast.LENGTH_LONG).show();
    }
}