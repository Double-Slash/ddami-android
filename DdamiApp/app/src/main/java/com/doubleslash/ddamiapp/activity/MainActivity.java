package com.doubleslash.ddamiapp.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.Verification.VerificationActivity;
import com.doubleslash.ddamiapp.activity.Verification.VerifiedActivity;
import com.doubleslash.ddamiapp.fragment.ActivitisFragment;
import com.doubleslash.ddamiapp.fragment.LikeFragment;
import com.doubleslash.ddamiapp.fragment.MainFragment;
import com.doubleslash.ddamiapp.fragment.MyRoomFragment;
import com.doubleslash.ddamiapp.fragment.SettingFragment;
import com.doubleslash.ddamiapp.fragment.Shop.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

import static android.content.res.ColorStateList.valueOf;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btn_verification = (Button)findViewById(R.id.btn_verification);
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

        //if user is verified
        //if() {
              //set btn_verification invisible, show program instead
              //set nav_myroom visible in the navigation menu
              btn_verification.setVisibility(View.GONE);
              nav_header_program.setVisibility(View.VISIBLE);
              nav_myroom.setVisibility(View.VISIBLE);
        //}

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
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, main).commit();
            }
        });

        nav_myroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyRoomFragment myroom = new MyRoomFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, myroom).commit();
            }
        });

        nav_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 LikeFragment like = new LikeFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, like).commit();
            }
        });

        nav_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopFragment shop = new ShopFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, shop).commit();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, activities).commit();
            }
        });

        nav_interested_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitisFragment activities = new ActivitisFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, activities).commit();
            }
        });

        nav_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingFragment settings= new SettingFragment();
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, settings).commit();
            }
        });

        //getSupportActionBar().setTitle("123123");
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

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
