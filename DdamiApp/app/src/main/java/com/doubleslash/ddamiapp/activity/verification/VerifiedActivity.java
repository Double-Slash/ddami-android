package com.doubleslash.ddamiapp.activity.verification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;
import com.doubleslash.ddamiapp.activity.login.LoginActivity;

public class VerifiedActivity extends AppCompatActivity {
    Button btn_goto_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_verified);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_goto_main = (Button) findViewById(R.id.btn_goto_main);
        btn_goto_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });
    }

    public void goToMain() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}