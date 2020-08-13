package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class DetailPieceUserDAO(
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)