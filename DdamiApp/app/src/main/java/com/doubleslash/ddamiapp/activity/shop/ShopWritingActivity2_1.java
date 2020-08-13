package com.doubleslash.ddamiapp.activity.shop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ShopWritingActivity2_1 extends AppCompatActivity {

    /*
    TabLayout mTabLayout;

    private FragmentManager fragmentManager;
    private ShopListFragment1 fragment1;
    private ShopListFragment2 fragment2;
    private ShopListFragment3 fragment3;
    private ShopListFragment4 fragment4;
    private ShopListFragment5 fragment5;

    private FragmentTransaction transaction;
    */

    EditText et_title;
    EditText et_price;
    EditText et_location;
    EditText et_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shop_writing_activity2_1);


    }

    @SuppressLint("CheckResult")
    public void onClickMaterialUpload(View view) {

        et_title = findViewById(R.id.et_title_material);
        et_price = findViewById(R.id.et_price_material);
        et_location = findViewById(R.id.et_location_material);
        et_description = findViewById(R.id.et_description_material);

        String title = et_title.getText().toString();
        String price = et_price.getText().toString();
        String location = et_location.getText().toString();
        String description = et_description.getText().toString();

        JsonObject jsonObject = new JsonObject();
        String token = getIntent().getStringExtra("token");

        jsonObject.addProperty("token", token);
        jsonObject.addProperty("title", title);
        jsonObject.addProperty("description", description);
        jsonObject.addProperty("price", price);
        jsonObject.addProperty("hasField", "공예");
        jsonObject.addProperty("locationName", location);

        /*

//pass it like this
File file = new File("/storage/emulated/0/Download/Corrections 6.jpg");
RequestBody requestFile =
        RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part is used to send also the actual file name
MultipartBody.Part body =
        MultipartBody.Part.createFormData("image", file.getName(), requestFile);

// add another part within the multipart request
RequestBody fullName =
        RequestBody.create(MediaType.parse("multipart/form-data"), "Your Name");

service.updateProfile(id, fullName, body, other);
         */
        File file = new File("D:\\boo.PNG");
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("text/plane"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("img", file.getName(), requestFile);

        ApiService.INSTANCE.getShopMaterialUploadService().shopMaterialUpload(body, token, jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Toast.makeText(this, "이미지 업로드 = " + it.toString(), Toast.LENGTH_LONG).show();
                        }, it -> {
                            Toast.makeText(this, "업로드 실패 = " + it.toString(), Toast.LENGTH_SHORT).show();
                        });

    }

}