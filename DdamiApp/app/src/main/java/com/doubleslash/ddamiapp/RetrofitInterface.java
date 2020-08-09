package com.doubleslash.ddamiapp;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("통신하기 위한/Api Server 주소")
    Call<JsonArray> getretrofitdata();

    @GET("통신하기 위한/Api Server 주소")
    Call<JsonArray> getretrofitquery(@Query("서버에 보낼 Query변수") String string);
}
