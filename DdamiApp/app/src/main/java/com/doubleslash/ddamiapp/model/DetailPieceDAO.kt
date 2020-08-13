package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class DetailPieceDAO(
        @SerializedName("piece")
    val piece: DetailPieceObjDAO,
        @SerializedName("result")
    val result: Int
)