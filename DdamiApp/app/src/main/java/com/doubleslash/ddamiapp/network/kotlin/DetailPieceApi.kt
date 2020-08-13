package com.doubleslash.ddamiapp.network.kotlin

import android.bluetooth.BluetoothClass.Device
import com.doubleslash.ddamiapp.model.DetailPieceDAO
import com.doubleslash.ddamiapp.model.DetailPieceObjDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface DetailPieceApi {
//        @POST("/piece/detail/5f3242d6eaf0a645c0d38b64") //{_id}
//        fun getDeatil(@Body Body: JsonObject
//        ): Single<DetailPieceDAO>

        @GET("/piece/detail/{FileId}")
        fun getDeatil(@Path("FileId") FileId: String): Single<DetailPieceDAO>


}