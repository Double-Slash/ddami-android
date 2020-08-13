package com.doubleslash.ddamiapp.db;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ManagerDB extends SQLiteOpenHelper {

    public static ManagerDB managerDB;
    private static SQLiteDatabase db = null;
    private static final int DB_VERSION = 1;
    private final String CREATE_DOCUMENT_TABLE = "CREATE TABLE IF NOT EXISTS Document(title TEXT, content TEXT)";
    private final String CREATE_IMG_TABLE = "CREATE TABLE IF NOT EXISTS Img(id integer primary key autoincrement,img BLOB)";
    public static Context con;


    public ManagerDB(@Nullable Context context) {
        super(context, "ManagerDB.db", null, 1);
    }
    public static synchronized ManagerDB getInstance(Context context) {
        con = context;
        if(managerDB == null) {
            managerDB = new ManagerDB(context); //onCreate() 실행
        }
        return managerDB;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCUMENT_TABLE);//글 임시저장
        db.execSQL(CREATE_IMG_TABLE);//사진 임시저장
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Document");
        db.execSQL("DROP TABLE IF EXISTS Img");
        onCreate(db);
    }
    public void deleteEveryData() { //모든 테이블의 전체 튜플 삭제
        db = getWritableDatabase();
        try {
            db.execSQL("DELETE FROM Document");
            db.execSQL("DELETE FROM Img");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertDocument(String title, String content){
        db = getWritableDatabase();
        if(title==null)
            title = "";
        if(content ==null)
            content = "";
        db.execSQL("INSERT INTO Document VALUES('"+title+"','"+content+"')");
    }
    //    public void insertImg(String title, String content){
//        db = getWritableDatabase();
//        if(title==null)
//            title = "";
//        if(content ==null)
//            content = "";
//        db.execSQL("INSERT INTO Document VALUES('"+title+"','"+content+"')");
//    }
    public static byte[] getBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
    public void addEntry( byte[] image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("img", image);
        database.insert( "Img" , null, cv );
    }
    public int DocumentCountDB(){
        int documentCount = 0;
        db = getWritableDatabase();
        try{
            documentCount = db.rawQuery("SELECT*FROM Document",null).getCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return documentCount;
    }
    public int ImgCountDB(){
        int imgCount = 0;
        db = getWritableDatabase();
        try{
            imgCount = db.rawQuery("SELECT*FROM Img",null).getCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return imgCount;
    }
    public String titleDB(){
        String title = "";
        db = getWritableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT title FROM Document",null);
            while(cursor.moveToNext()) {
                title = cursor.getString(0);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }
    public String contentDB(){
        String content = "";
        db = getWritableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT content FROM Document",null);
            while(cursor.moveToNext()) {
                content = cursor.getString(0);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    public Bitmap imgDB(){
        Bitmap bitmap = null;
        byte[] bytes = null;
        db = getWritableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM Img",null);
            while(cursor.moveToNext()) {
                bytes = cursor.getBlob(cursor.getColumnIndex("img"));
                bitmap = getImage(bytes);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
//    public ArrayList<Bitmap> getAllBitmap(){
//        Bitmap bitmap = null;
//        Cursor cursor = db.rawQuery("SELECT*FROM Img",null);
//        if(cursor != null){
//            while (cursor.moveToNext()){
//                byte[] bolb = cursor.getBlob()
//            }
//        }
//    }

}
