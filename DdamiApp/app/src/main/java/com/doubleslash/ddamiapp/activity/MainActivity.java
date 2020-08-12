package com.doubleslash.ddamiapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.verification.VerificationActivity;
import com.doubleslash.ddamiapp.fragment.ActivitisFragment;
import com.doubleslash.ddamiapp.fragment.LikeFragment;
import com.doubleslash.ddamiapp.fragment.MainFragment;
import com.doubleslash.ddamiapp.fragment.MyRoomFragment;
import com.doubleslash.ddamiapp.fragment.SettingFragment;
import com.doubleslash.ddamiapp.fragment.shop.ShopFragment;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Long backTime = 0L;

    NavController navController;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    AppBarConfiguration appBarConfigurationBottom;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    Button btn_verification;
    TextView nav_main, nav_myroom, nav_like, nav_shop, nav_purchase, nav_shop_like, nav_activities, nav_interested_activities, nav_settings;
    TextView nav_header_program;
    ImageView nav_profile_img;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        String id = getIntent().getStringExtra("id");
        String token = getIntent().getStringExtra("token");

        Toast.makeText(this, "id = " + id + "token = " + token, Toast.LENGTH_LONG).show();

        btn_verification = (Button) findViewById(R.id.btn_verification);
        nav_main = (TextView) findViewById(R.id.nav_main);
        nav_myroom = (TextView) findViewById(R.id.nav_myroom);
        nav_like = (TextView) findViewById(R.id.nav_like);
        nav_shop = (TextView) findViewById(R.id.nav_shop);
        nav_purchase = (TextView) findViewById(R.id.nav_purchase);
        nav_shop_like = (TextView) findViewById(R.id.nav_shop_like);
        nav_activities = (TextView) findViewById(R.id.nav_activities);
        nav_interested_activities = (TextView) findViewById(R.id.nav_interested_activities);
        nav_settings = (TextView) findViewById(R.id.nav_settings);
        nav_header_program = (TextView) findViewById(R.id.nav_header_program);
        nav_profile_img = (ImageView) findViewById(R.id.nav_profile_img);

        JsonObject inputJson = new JsonObject();
        Bundle bundle = new Bundle();

        ApiService.INSTANCE.getMyroomUser().myroom(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Log.e("sss", it.toString());
                            bundle.putString("Id", it.getUser().getUserId());
                            for (int i = 0; i < it.getUser().getLikeField().size(); i++) {
                                bundle.putString("LikeField" + String.valueOf(i), it.getUser().getLikeField().get(i));
                            }
                            bundle.putInt("FieldCount", it.getUser().getLikeField().size());
                            bundle.putInt("Follow", it.getUser().getFollow());
                            bundle.putInt("Follower", it.getUser().getFollower());
                            for (int i = 0; i < it.getUser().getMyPieces().size(); i++) {
                                bundle.putString("File" + String.valueOf(i), it.getUser().getMyPieces().get(i).getFileUrl().get(0));
                                bundle.putString("FileId" + String.valueOf(i), it.getUser().getMyPieces().get(i).getId());
                            }
                            Log.e("hhhhhere", String.valueOf(it.getUser().getMyPieces().size()));
                            bundle.putInt("FileCount", it.getUser().getMyPieces().size());
                            bundle.putString("Username", it.getUser().getUserName());
                            bundle.putString("ProfileImg", it.getUser().getImageUrl());
                            bundle.putBoolean("State", it.getUser().getState());

                            //set profile img
                            Picasso.get().load(it.getUser().getImageUrl()).into(nav_profile_img);

                            //if user is verified
                            if (it.getUser().getState()) {
                                //set btn_verification invisible, show program instead
                                //set nav_myroom visible in the navigation menu
                                btn_verification.setVisibility(View.GONE);
                                nav_header_program.setVisibility(View.VISIBLE);
                                nav_myroom.setVisibility(View.VISIBLE);
                            }
                        },
                        it -> {
                            Log.e("fff", it.toString());
                        }
                );

        //verification button onClick event
        btn_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        //navigation menu clicked event
        nav_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment main = new MainFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, main)
                        .commit();
            }
        });

        nav_myroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyRoomFragment myroom = new MyRoomFragment();
                drawerLayout.closeDrawers();
                myroom.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, myroom)
                        .commit();
            }
        });

        nav_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LikeFragment like = new LikeFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, like)
                        .commit();
            }
        });

        nav_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopFragment shop = new ShopFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, shop)
                        .commit();
            }
        });

        nav_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        nav_shop_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        nav_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitisFragment activities = new ActivitisFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, activities)
                        .commit();
            }
        });

        nav_interested_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitisFragment activities = new ActivitisFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, activities)
                        .commit();
            }
        });

        nav_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingFragment settings = new SettingFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, settings)
                        .commit();
            }
        });

        //activity to mainFragment
//        String id = getIntent().getStringExtra("id");
//        String token = getIntent().getStringExtra("token");

//        Bundle bundle = new Bundle();
//        bundle.putString("id", id);
//
//        fragment = new MainFragment();
//        fragment.setArguments(bundle);


//        Intent tokenIntent = new Intent(this, MainFragment.class);
//        tokenIntent.putExtra("token",token);
//        startActivity(tokenIntent);


        //푸시 알림
        Intent intent = getIntent();
        if (intent != null) {//푸시알림을 선택해서 실행한것이 아닌경우 예외처리
            String notificationData = intent.getStringExtra("test");
            if (notificationData != null)
                Log.d("FCM_TEST", notificationData);
        }
    }

    //화면 전환
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).commit();
    }

    private void initViews() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        //NavController 생성
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //AppBarConfig 생성
        Set<Integer> pageSet = new HashSet<>();

        pageSet.add(R.id.page_main);
        pageSet.add(R.id.page_shop);
        pageSet.add(R.id.page_activities);
        pageSet.add(R.id.page_chat);

        appBarConfiguration =
                new AppBarConfiguration.Builder(pageSet)
                        .setOpenableLayout(drawerLayout)
                        .build();

        // 액션바에다 컨트롤러랑 AppBarConfig 연결
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //BottomNavigation setting
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        //navigationView
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (System.currentTimeMillis() - backTime < 2000) {
                finish();
            }
            Toast.makeText(this, "종료하시려면 다시한번 눌러주세요.", Toast.LENGTH_SHORT).show();
            backTime = System.currentTimeMillis();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    //open verifiedActivity
    private void openNewActivity() {
        startActivity(new Intent(getApplicationContext(), VerificationActivity.class));
    }
}