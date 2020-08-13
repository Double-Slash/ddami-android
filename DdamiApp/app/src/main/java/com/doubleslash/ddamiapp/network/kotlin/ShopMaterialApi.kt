package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.ShopMaterialDAO
import com.doubleslash.ddamiapp.model.ShopWorkDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopMaterialApi {
    @POST("/shop/search/material")
    fun shopMaterial(@Body Body: JsonObject
    ): Single<ShopMaterialDAO>
}