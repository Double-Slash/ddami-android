package com.doubleslash.ddamiapp.activity.verification;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class VerificationActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int FILE_REQUEST_CODE = 2;
    Button btn_modern, btn_graphic, btn_craft, btn_video, btn_industrial, btn_space, btn_costume;
    Button btn_verify, btn_goto_main;
    ImageButton btn_camera, btn_file;
    TextView tv_file_attached;
    File tempFile = null;
    String pictureFilePath;
    EditText et_school, et_program, et_studentId;
    List<String> likeFields = new ArrayList<String>();

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
        btn_camera = (ImageButton) findViewById(R.id.btn_camera);
        btn_file = (ImageButton) findViewById(R.id.btn_file);
        tv_file_attached = (TextView) findViewById(R.id.file_attached);
        et_school = (EditText) findViewById(R.id.school);
        et_program = (EditText) findViewById(R.id.program);
        et_studentId = (EditText) findViewById(R.id.studentid);

        btn_modern.setOnClickListener(this);
        btn_graphic.setOnClickListener(this);
        btn_craft.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_industrial.setOnClickListener(this);
        btn_space.setOnClickListener(this);
        btn_costume.setOnClickListener(this);

        btn_verify.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_verify.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#322FA0")));
                } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                    String school = et_school.getText().toString();
                    String program = et_program.getText().toString();
                    String student_id = et_studentId.getText().toString();
                    JsonObject inputJson = new JsonObject();

                    if(isEmpty(school)) {
                        showMsg(0);
                    } else if (isEmpty(program)) {
                        showMsg(1);
                    } else if (isEmpty(student_id)) {
                        showMsg(2);
                    } else if (isEmpty(tv_file_attached.getText().toString())) {
                        showMsg(3);
                    } else {

                        inputJson.addProperty("university", school);
                        inputJson.addProperty("department", program);
                        inputJson.addProperty("number", student_id);

                        addIfSelected(btn_modern);
                        addIfSelected(btn_graphic);
                        addIfSelected(btn_craft);
                        addIfSelected(btn_video);
                        addIfSelected(btn_industrial);
                        addIfSelected(btn_space);
                        addIfSelected(btn_costume);

                        inputJson.addProperty("likeField", "");
                        //inputJson.addProperty("likeField", likeFields);
                        verify(inputJson);

                        openNewActivity();
                    }
                }
                return true;
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

    public void addIfSelected(Button b) {
        if(b.isSelected()) {
            likeFields.add(b.getText().toString());
        }
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
            b.setTextColor(Color.parseColor("#808080"));
            b.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            b.setSelected(false);
        } else if (!b.isSelected()) {
            b.setTextColor(Color.parseColor("#322FA0"));
            b.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E6E6FA")));
            b.setTypeface(null, Typeface.BOLD);
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
    private void openNewActivity() {
//        Intent intent = new Intent(this, VerifiedActivity.class);
//        startActivity(intent);
    }

    private boolean isEmpty(String s) {
        if (s.trim().length() > 0)
            return false;
        return true;
    }

    private void showMsg(int i) {
        switch (i) {
            case 0:
                Toast.makeText(this, "학교를 입력해주세요", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "학과를 입력해주세요", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "학번을 입력해주세요", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "인증 파일을 첨부해주세요", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void verify(JsonObject inputJson) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjMxMzlhOGNiMGUwZjQyZDBhMDJiOWEiLCJ1c2VySWQiOiJ0ZXN0IiwiaWF0IjoxNTk3MjU0MjgzLCJleHAiOjE1OTc4NTkwODMsImlzcyI6ImRkYW1pLmNvbSIsInN1YiI6InVzZXJJbmZvIn0.vXZr-6P0IQXNYaknHIgqBhXUlOnknobDU9uY2ojPVGk";
        inputJson.addProperty("token", token);
        ApiService.INSTANCE.getVerifyUser().verify(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Log.e("sss!!!", it.toString());
                        },
                        it -> {
                            Log.e("fff!!!", it.toString());
                        }
                );
    }
}