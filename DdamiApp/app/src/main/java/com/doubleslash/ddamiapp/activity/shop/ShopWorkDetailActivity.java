package com.doubleslash.ddamiapp.activity.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.fragment.shop.ShopFirstFragment;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShopWorkDetailActivity extends AppCompatActivity {

    TextView workTag;
    TextView title;
    TextView userName;
    TextView price;
    TextView location;
    TextView description;

    String id;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_work_detail);

        //ShopWorkItem shopWorkItem= ShopFirstFragment.getShopWorkItem();

        workTag=findViewById(R.id.tv_detail_work_tag);
        title=findViewById(R.id.tv_work_detail_title);
        userName=findViewById(R.id.tv_work_detail_userName);
        price=findViewById(R.id.tv_work_detail_price);
        location=findViewById(R.id.tv_work_detail_location);
        description=findViewById(R.id.tv_work_detail_description);

        id = getIntent().getStringExtra("id");
        //JsonObject inputJson = new JsonObject();

        //inputJson.addProperty("token", token);
        //Log.e("test",token);
        ApiService.INSTANCE.getShopWorkDetailService().shopWorkDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        subs -> {
                            if(subs.getProduct().getHasField().get(0)==null){
                                workTag.setText("그래픽 디자인");
                            }
                            else{
                                workTag.setText(subs.getProduct().getHasField().get(0));
                            }
                            title.setText(subs.getProduct().getTitle());
                            userName.setText(subs.getProduct().getAuthor().getUserName());
                            price.setText(subs.getProduct().getPrice()+" 원");
                            location.setText(subs.getProduct().getLocationName());
                            description.setText(subs.getProduct().getDescription());
                        },
                        subs -> {
                            //Log.e("미대생 인증 확인 오류", it.toString());
                        }
                );
    }
}