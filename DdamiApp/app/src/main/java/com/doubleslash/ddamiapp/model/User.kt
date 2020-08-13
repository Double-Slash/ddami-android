package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("follow")
    val follow: Int,
    @SerializedName("follower")
    val follower: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("likeField")
    val likeField: List<String>,
    @SerializedName("myPieces")
    val myPieces: List<MyPiece>,
    @SerializedName("state")
    val state: Boolean,
    @SerializedName("stateMessage")
    val stateMessage: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)