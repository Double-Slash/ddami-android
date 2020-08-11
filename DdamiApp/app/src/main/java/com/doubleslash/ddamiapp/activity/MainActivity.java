package com.doubleslash.ddamiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

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
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Long backTime = 0L;

    NavController navController;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    AppBarConfiguration appBarConfigurationBottom;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        String id = getIntent().getStringExtra("id");
        String token = getIntent().getStringExtra("token");

        Toast.makeText(this,"id = "+id +"token = "+token,Toast.LENGTH_LONG).show();


        //getSupportActionBar().setTitle("123123");

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

    private void initViews(){
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
    public boolean onSupportNavigateUp () {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setActionBarTitle (String title){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
