package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyroomUserDAO
import com.doubleslash.ddamiapp.model.ShopMaterialUploadDAO
import com.doubleslash.ddamiapp.model.ShopWorkDetailDAO
import com.doubleslash.ddamiapp.model.SignUpDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*

interface ShopWorkDetailApi {
    @POST("/shop/detail/product/{id}")
    fun shopWorkDetail(@Path("id") id: String): Single<ShopWorkDetailDAO>
}