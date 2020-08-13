package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.DetailPieceDAO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface LikeTFApi {

    @GET("/user/like/piece/{FileId}")
    fun getBoolean(@Path("FileId") FileId: String): Single<DetailPieceDAO>

}