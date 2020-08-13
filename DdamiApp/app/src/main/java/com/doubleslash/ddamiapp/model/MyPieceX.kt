package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyPieceX(
    @SerializedName("fileUrl")
    val fileUrl: List<String>,
    @SerializedName("_id")
    val id: String
)