package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("follow")
    val follow: Int,
    @SerializedName("followerCount")
    val followerCount: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("likeField")
    val likeField: List<Any>,
    @SerializedName("myPieces")
    val myPieces: List<MyPieceX>,
    @SerializedName("state")
    val state: Boolean,
    @SerializedName("stateMessage")
    val stateMessage: String,
    @SerializedName("student")
    val student: StudentX,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)