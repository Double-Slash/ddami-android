package com.doubleslash.ddamiapp.network.kotlin.java;

import com.doubleslash.ddamiapp.model.UploadPieceDAO;
import com.doubleslash.ddamiapp.model.UploadPieceDAO.UploadPieceResponse;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadPieceApi {
    @POST("/user/upload/piece")
    @Multipart
    Call<UploadPieceResponse> UploadPiece(@Header("x-access-token") String token, @Part("title") RequestBody title, @Part("description") RequestBody description
    , @Part ArrayList<MultipartBody.Part> imgList);
}
