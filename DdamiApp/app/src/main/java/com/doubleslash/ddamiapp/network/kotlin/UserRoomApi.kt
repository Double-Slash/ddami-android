package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.MyroomPageDAO
import com.doubleslash.ddamiapp.model.UserRoomDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface UserRoomApi {
    @POST("/user/detail/{id}"  )
    fun userroom(@Path("id") id : String): Single<UserRoomDAO>
}