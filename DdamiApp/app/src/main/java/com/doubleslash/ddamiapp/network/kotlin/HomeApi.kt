package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.HomeDAO
import com.doubleslash.ddamiapp.model.SignUpDAO
import com.doubleslash.ddamiapp.model.UserAuthDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeApi {
    @POST("/api/search")
    fun pieceSearch(@Body Body: JsonObject
    ): Single<HomeDAO>

    @POST("/user/auth")
    fun userAuth(@Body Body: JsonObject
    ): Single<UserAuthDAO>
}