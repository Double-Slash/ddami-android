package com.doubleslash.ddamiapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doubleslash.ddamiapp.R;

import java.lang.invoke.WrongMethodTypeException;
import java.util.List;

public class SavePopUP extends Dialog implements View.OnClickListener {
    Context context;
    Button tempSave, saveCancel;
    public static int tempCount = 0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_save_pop_up);
        tempSave = findViewById(R.id.tempSave);
        saveCancel = findViewById(R.id.saveCancel);
        tempSave.setOnClickListener(this);
        saveCancel.setOnClickListener(this);
    }
    public SavePopUP(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tempSave:
                tempCount++;
                ((WritingActivity)context).finish();
            case R.id.saveCancel:
                dismiss();
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
