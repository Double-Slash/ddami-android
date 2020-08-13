package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.DetailPieceDAO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface LikeTFApi {

    @POST("/user/like/piece/{FileId}")
    fun getBoolean(@Header("x-access-token") token:String, @Path("FileId") FileId: String): Single<DetailPieceDAO>

}