package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyroomPageDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRoomApi {
    @POST("/user/detail/{id}"  )
    fun myroom(@Body Body: JsonObject): Single<MyroomPageDAO>
}