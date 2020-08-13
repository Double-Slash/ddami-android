package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyLikeListDAO
import io.reactivex.Single
import retrofit2.http.GET

interface MyLikeListApi {

    @GET("/user/mylikes")
    fun getLikeList(): Single<MyLikeListDAO>

}