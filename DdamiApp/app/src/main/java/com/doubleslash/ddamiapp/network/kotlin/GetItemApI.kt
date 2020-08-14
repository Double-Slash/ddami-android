package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.GetItemDAO
import io.reactivex.Single
import retrofit2.http.Header
import retrofit2.http.POST

interface GetItemApI {
    @POST("/user/like/products")
    fun getLikeList(@Header("x-access-token") token:String): Single<GetItemDAO>
}