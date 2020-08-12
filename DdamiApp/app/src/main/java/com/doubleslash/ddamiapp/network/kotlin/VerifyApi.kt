package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.VerifyDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface VerifyApi {
    @POST("/user/auth/student")
    fun login(@Body Body: JsonObject
    ): Single<VerifyDAO>
}