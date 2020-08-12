package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.SignUpDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpApi {
    @POST("/user/join")
    fun signUp(@Body Body: JsonObject
    ): Single<SignUpDAO>
}