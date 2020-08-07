package com.doubleslash.ddamiapp.activity.Verification;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.doubleslash.ddamiapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int FILE_REQUEST_CODE = 2;
    Button btn_modern, btn_graphic, btn_craft, btn_video, btn_industrial, btn_space, btn_costume;
    Button btn_verify, btn_goto_main;
    Button btn_camera, btn_file;
    TextView tv_file_attached;
    File tempFile = null;
    String pictureFilePath;

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
        btn_verify = (Button) findViewById(R.id.btn_verify);
        btn_goto_main = (Button) findViewById(R.id.btn_goto_main);
        btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_file = (Button) findViewById(R.id.btn_file);
        tv_file_attached = (TextView) findViewById(R.id.file_attached);

        btn_modern.setOnClickListener(this);
        btn_graphic.setOnClickListener(this);
        btn_craft.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_industrial.setOnClickListener(this);
        btn_space.setOnClickListener(this);
        btn_costume.setOnClickListener(this);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewAcitivity();
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }
        });

        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), FILE_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //select camera capture
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            File imgFile = new File(pictureFilePath);
            String fileName = pictureFilePath.substring(pictureFilePath.lastIndexOf("/") + 1);
            if (imgFile.exists()) {
                tv_file_attached.setText(fileName);
            }
        }

        //select file upload
        if (requestCode == FILE_REQUEST_CODE) {
            Uri selectedImage = data.getData();
            String path = getPathFromURI(selectedImage);
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tv_file_attached.setText(fileName);
        }
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    //onClick event for field options
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

    private String getPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            return uri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }

    //Camera capture
    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            //startActivityForResult(intent, CAMERA_REQUEST_CODE);
            File pictureFile = null;
            try {
                pictureFile = getPictureFile();
            } catch (IOException e) {
                Toast.makeText(this, "이미지 처리 오류", Toast.LENGTH_SHORT).show();
                finish();
                e.printStackTrace();
            }

            if (pictureFile != null) {
                Uri photoUri = FileProvider.getUriForFile(this, "{package_name}.fileprovider", pictureFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        }
    }

    //Create file
    private File getPictureFile() throws IOException {
        String imageFileName = "ddami_verify";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        pictureFilePath = image.getAbsolutePath();
        return image;
    }

    //open verifiedActivity
    private void openNewAcitivity() {
        Intent intent = new Intent(this, VerifiedActivity.class);
        startActivity(intent);
    }
}