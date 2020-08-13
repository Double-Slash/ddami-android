package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.USerDetailDAO
import com.doubleslash.ddamiapp.model.testDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface testApi {
    @POST("/user/like/products")
    fun getTest(@Body Body: JsonObject
    ): Single<testDAO>
}