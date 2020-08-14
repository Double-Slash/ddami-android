package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.*
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.*

interface FollowApi {
   @POST("/user/follow/{id}")
   fun follow(@Header("x-access-token") token : String, @Path("id") id :String) : Single<FollowDAO>

   @POST("/api/author/search")
   fun checkFollow(@Body Body : JsonObject) : Single<AuthorSearchDAO>
}