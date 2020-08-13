package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyLikeListDAO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyLikeListApi {

    @POST("/user/mylikes")
    fun getLikeList(@Header("x-access-token") token:String): Single<MyLikeListDAO>

}