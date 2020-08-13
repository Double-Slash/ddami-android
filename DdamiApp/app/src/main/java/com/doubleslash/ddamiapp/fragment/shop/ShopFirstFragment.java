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
import com.doubleslash.ddamiapp.activity.shop.ShopWorkDetailActivity;
import com.doubleslash.ddamiapp.adapter.OnItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopItemClickListener;
import com.doubleslash.ddamiapp.model.Product;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.activity.shop.ShopWritingActivity1_1;

import com.doubleslash.ddamiapp.adapter.ShopWorkAdapter;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShopFirstFragment extends Fragment implements OnShopItemClickListener {

    // 따미샵-작품샵 배열
    ArrayList<ShopWorkItem> mData=null;
    RecyclerView.Adapter mAdapter=null;
    RecyclerView recyclerView=null;

    Context context;
    static ShopWorkItem shopWorkItem;


    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.shop_first_recyclerview);
        mData = new ArrayList<ShopWorkItem>();

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
        ApiService.INSTANCE.getShopWorkService().shopWork(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Toast.makeText(context, "서버 연결 성공"+it.getProducts().get(0).get_id(), Toast.LENGTH_SHORT).show();
                            Log.e("서버 연결 확인",it.getProducts().get(0).getPieces().get(0).getFileUrl().toString());

                            for(int i = 0; i<it.getProducts().size(); i++){
                                Product product = it.getProducts().get(i);
                                mData.add(new ShopWorkItem(product.getPieces().get(0).getFileUrl(), product.getHasField(), product.getTitle(), product.getLocationName(), product.getPrice(), product.getViews(), product.getLikeCount()));
                            }

                            mAdapter = new ShopWorkAdapter(mData,this::onShopWorkClicked);
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

    // 따미샵-작품: 플로팅버튼 이벤트처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=container.getContext();

        View v=inflater.inflate(R.layout.fragment_shop_first, container, false);
        FloatingActionButton btn=v.findViewById(R.id.floatingBtn_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), ShopWritingActivity1_1.class));
                //getActivity().startActivity(new Intent(getActivity(), ShopNormalActivity.class));
            }
        });

        return v;
    }

    @Override
    public void onShopWorkClicked(ShopWorkItem shopWorkItem) {
        Toast.makeText(getContext(), shopWorkItem.getmWork(), Toast.LENGTH_LONG).show();
        this.shopWorkItem=shopWorkItem;
        getActivity().startActivity(new Intent(getActivity(), ShopWorkDetailActivity.class));
    }

    public static ShopWorkItem getShopWorkItem(){

        return shopWorkItem;
    }
}