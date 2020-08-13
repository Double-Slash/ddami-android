package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyroomPageDAO
import com.doubleslash.ddamiapp.model.MyroomUserDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MyroomUserApi {
    @POST("/user/detail/5f3139a8cb0e0f42d0a02b9a"  )
    fun myroom(@Body Body:JsonObject): Single<MyroomPageDAO>
}