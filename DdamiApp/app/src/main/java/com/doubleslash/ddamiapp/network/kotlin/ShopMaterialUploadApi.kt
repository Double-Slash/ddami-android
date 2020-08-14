package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.ShopMaterialUploadDAO
import com.doubleslash.ddamiapp.model.SignUpDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*

interface ShopMaterialUploadApi {
    @POST("/shop/upload/material")
    fun shopMaterialUpload(@Part image : MultipartBody.Part, @Header("x-access-token")token : String, @Body Body: JsonObject
    ): Single<ShopMaterialUploadDAO>
}
