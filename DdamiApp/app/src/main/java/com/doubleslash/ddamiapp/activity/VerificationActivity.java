package com.doubleslash.ddamiapp.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.doubleslash.ddamiapp.R;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_modern;
    Button btn_graphic;
    Button btn_craft;
    Button btn_video;
    Button btn_industrial;
    Button btn_space;
    Button btn_costume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_verification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_modern = (Button) findViewById(R.id.btn_modern_art);
        btn_graphic = (Button) findViewById(R.id.btn_graphic_design);
        btn_craft = (Button) findViewById(R.id.btn_craft_art);
        btn_video = (Button) findViewById(R.id.btn_video_design);
        btn_industrial = (Button) findViewById(R.id.btn_industrial_design);
        btn_space = (Button) findViewById(R.id.btn_space_design);
        btn_costume = (Button) findViewById(R.id.btn_costume_design);

        btn_modern.setOnClickListener(this);
        btn_graphic.setOnClickListener(this);
        btn_craft.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_industrial.setOnClickListener(this);
        btn_space.setOnClickListener(this);
        btn_costume.setOnClickListener(this);

    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        if (b.isSelected()) {
            b.setTextColor(Color.parseColor("#A0A0A0"));
            b.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E9E9E9")));
            b.setSelected(false);
        } else if (!b.isSelected()) {
            b.setTextColor(Color.parseColor("#ffffff"));
            b.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#B7B7B7")));
            b.setSelected(true);
        }
    }

}