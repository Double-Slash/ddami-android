package com.doubleslash.ddamiapp.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.fragment.FilterFragment;
import com.doubleslash.ddamiapp.model.UploadPieceDAO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WritingActivity extends AppCompatActivity {
    private static final int PICK_ALBUM = 1;
    private static final int PICK_CAMERA = 2;
    private File tempFile;
    int writingLayoutId = 0, writingImgId=0;
    static int writing_imgLayoutCount =0;
    String writing_layout, writing_img;
    ArrayList<String> fileUri;
    EditText e_writingContent, e_writingTitle;
    Cursor cursor;
    String filePath;
    int column_index;
    Bitmap originalBm;
    Uri takePhotoUri;
    Fragment filterFragment;
    FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        tedPermission();
//        filterFragment = new FilterFragment();
//        manager = getSupportFragmentManager();
//        transaction = manager.beginTransaction();
//        transaction.replace(R.id.filter_whole_layout, filterFragment).commitAllowingStateLoss();
        findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writing_imgLayoutCount++;
//                imgViewAdd();
                takePhoto();
            }
        });
//        filterFragment = getSupportFragmentManager().findFragmentById(R.id.filter_fragment);

        findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writing_imgLayoutCount++;
//                imgViewAdd();
                goToAlbum();
            }
        });
        findViewById(R.id.btnReg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImgUpload();
            }
        });
//        findViewById(R.id.add_filter).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                transaction.replace(R.id.filter_whole_layout,filterFragment).commitAllowingStateLoss();
//            }
//        });
        //0이 거래 대기
        //1이 거래중
        //-1 거래완료
    }
    private void tedPermission(){//권한 요청 함수
         PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                //권한 요청 성공
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                //권한 요청 실패
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }
    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_ALBUM);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        fileUri = new ArrayList<>();
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_ALBUM) {
            Uri photoUri = data.getData();
            cursor = null;
            try {
                String[] proj = { MediaStore.Images.Media.DATA };
                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);
                assert cursor != null;
                column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));
                fileUri.add(cursor.getString(column_index));

            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            setImage();
        }
        else if(requestCode==PICK_CAMERA){
            setImage();
        }

    }

    private void setImage(){
        int id =0;
        id = writing_imgLayoutCount;
        writing_img = "writing_img"+writing_imgLayoutCount;
        writingImgId = getResources().getIdentifier(writing_img,"id",getPackageName());
        System.out.println(writing_img+" ssssssssss");
        ImageView iv = new ImageView(this);
        iv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        BitmapFactory.Options options = new BitmapFactory.Options();
        originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        iv.setImageBitmap(originalBm);
        iv.setId(writingImgId);
        LinearLayout imgLayout = (LinearLayout)findViewById(R.id.writingImgLayout);
        imgLayout.addView(iv,300,200);
    }
    private void takePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            Toast.makeText(this, "이미지 처리 오류", Toast.LENGTH_SHORT).show();
            finish();
            e.printStackTrace();
        }
        if (tempFile != null) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this,"{package_name}.fileprovider",tempFile));
            startActivityForResult(intent, PICK_CAMERA);
        }
    }
    private File createImageFile() throws IOException {

        // 이미지 파일 이름 + 시간
        String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        String imageFileName = "ddamiImg01_" + timeStamp + "_";
        // 이미지가 저장될 폴더 이름
        filePath = Environment.getExternalStorageDirectory() + "/ddamiImg/";
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/ddamiImg/");
        if (!storageDir.exists()) storageDir.mkdirs();
        // 빈 파일 생성
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        return image;
    }
    public void ImgUpload(){

        e_writingContent = findViewById(R.id.writingContent);
        e_writingTitle = findViewById(R.id.writingTitle);
        ArrayList<MultipartBody.Part> imgList = new ArrayList<>();
        for(int i = 0; i < fileUri.size(); i++){
            File file = new File(fileUri.get(i));
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"),file);
            imgList.add(MultipartBody.Part.createFormData("img", file.getName(), requestBody));
        }

        Intent intent = getIntent();
        String token = intent.getExtras().getString("token");
        RequestBody content = RequestBody.create(MediaType.parse("text/plain"),e_writingContent.getText().toString());
        RequestBody title = RequestBody.create(MediaType.parse("text/plain"), e_writingTitle.getText().toString());
        if(e_writingTitle.getText().toString().equals(null) || e_writingTitle.getText().toString().equals(null) ){
            Toast.makeText(getApplicationContext(),"비어져 있는 칸이 있습니다. ", Toast.LENGTH_LONG).show();
        }
        else {
            ApiService.INSTANCE.getUploadPieceService().UploadPiece(token,
                    title, content, imgList).enqueue(new Callback<UploadPieceDAO.UploadPieceResponse>() {
                @Override
                public void onResponse(Call<UploadPieceDAO.UploadPieceResponse> call, Response<UploadPieceDAO.UploadPieceResponse> response) {
                    UploadPieceDAO.UploadPieceResponse result = response.body();

                    Toast.makeText(WritingActivity.this, result.getMessage(), Toast.LENGTH_LONG).show();
                    if (result.getState() == 0) {
                        System.out.println("sdfsdfsdfdfdfsfsdfsd");
                        finish();
                    }
                    if (response.isSuccessful()) {

                    } else {
                        ResponseBody error = response.errorBody();
                        System.out.println(error.toString());
                    }
                }

                @Override
                public void onFailure(Call<UploadPieceDAO.UploadPieceResponse> call, Throwable t) {
                    Toast.makeText(WritingActivity.this, "글작성 에러", Toast.LENGTH_LONG).show();
                    Log.e("글작성 에러", t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}
