package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.ShopWorkDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopWorkApi {
    @POST("/shop/search/piece")
    fun shopWork(@Body Body: JsonObject
    ): Single<ShopWorkDAO>
}