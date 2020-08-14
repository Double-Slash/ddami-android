package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyInfoDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MyInfoApi {
    @POST("/user/auth"  )
    fun myinfo(@Body Body: JsonObject): Single<MyInfoDAO>
}