package com.doubleslash.ddamiapp.network.kotlin

import android.bluetooth.BluetoothClass.Device
import com.doubleslash.ddamiapp.model.DetailPieceDAO
import com.doubleslash.ddamiapp.model.DetailPieceObjDAO
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*


interface DetailPieceApi {
//        @POST("/piece/detail/5f350150b6789b2ae0da7820") //{_id}
//        fun getDeatil(@Body Body: JsonObject
//        ): Single<DetailPieceDAO>

        @GET("/piece/detail/{FileId}")
        fun getDeatil(@Path("FileId") FileId: String): Single<DetailPieceDAO>


}