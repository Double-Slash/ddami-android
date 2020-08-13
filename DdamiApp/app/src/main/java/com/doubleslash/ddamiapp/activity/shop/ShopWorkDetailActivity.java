package com.doubleslash.ddamiapp.activity.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.fragment.shop.ShopFirstFragment;
import com.doubleslash.ddamiapp.model.ShopWorkItem;

public class ShopWorkDetailActivity extends AppCompatActivity {

    TextView workTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_work_detail);

        ShopWorkItem shopWorkItem= ShopFirstFragment.getShopWorkItem();



    }
}