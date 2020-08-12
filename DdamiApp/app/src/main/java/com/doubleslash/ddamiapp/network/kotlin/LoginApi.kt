package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.LoginDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/user/login")
    fun login(@Body Body: JsonObject
    ): Single<LoginDAO>
}