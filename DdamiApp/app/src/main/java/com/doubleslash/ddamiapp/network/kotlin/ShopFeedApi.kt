package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.ShopFeedDAO
import com.doubleslash.ddamiapp.model.ShopWorkDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ShopFeedApi {
    @POST("/user/mypieces")
    fun shopFeed(@Header("x-access-token")token : String , @Body Body: JsonObject
    ): Single<ShopFeedDAO>
}