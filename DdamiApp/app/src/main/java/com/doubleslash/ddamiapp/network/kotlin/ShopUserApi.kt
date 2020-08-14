package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyroomUserDAO
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Path

interface ShopUserApi {
    @POST("/user/detail/{id}")
    fun shopUserAuth(@Path("id") id: String): Single<MyroomUserDAO>
}