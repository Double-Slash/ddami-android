package com.doubleslash.ddamiapp.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doubleslash.ddamiapp.R;

import java.util.List;

public class BackPopUP extends Dialog implements View.OnClickListener {
    Context context;
    Button cancelWriting, noCancel;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing_back_pop_up);
        cancelWriting = findViewById(R.id.cancelWriting);
        noCancel = findViewById(R.id.noCancel);
        cancelWriting.setOnClickListener(this);
        noCancel.setOnClickListener(this);
    }
    public BackPopUP(@NonNull Context context) {
        super(context);
        this.context = context;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancelWriting:
                dismiss();
            case R.id.noCancel:
                ((WritingActivity)context).finish();
                break;
        }
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
