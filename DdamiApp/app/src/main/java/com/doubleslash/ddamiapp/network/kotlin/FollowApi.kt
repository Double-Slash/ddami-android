package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.FollowDAO
import com.doubleslash.ddamiapp.model.HomeDAO
import com.doubleslash.ddamiapp.model.UserAuthDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface FollowApi {
   @POST("/user/follow/{id}")
   fun follow(@Path("id") Id : String, @Body Body:JsonObject) : Single<FollowDAO>
}