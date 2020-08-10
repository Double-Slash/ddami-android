package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.DetailPieceDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface DetailPieceApi {
        @POST("/piece/detail/5f2ac8d68f56110128e4a885")
        fun getDeatil(@Body Body: JsonObject
        ): Single<DetailPieceDAO>
}