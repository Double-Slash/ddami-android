package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.AuthorSearchDAO
import com.doubleslash.ddamiapp.model.FollowDAO
import com.doubleslash.ddamiapp.model.HomeDAO
import com.doubleslash.ddamiapp.model.UserAuthDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface FollowApi {
   @POST("/user/follow/{id}")
   fun follow(@Header("x-access-token") token : String, @Path("id") id :String) : Single<FollowDAO>

   @POST("/api/author/search")
   fun checkFollow(@Body Body : JsonObject) : Single<AuthorSearchDAO>
}