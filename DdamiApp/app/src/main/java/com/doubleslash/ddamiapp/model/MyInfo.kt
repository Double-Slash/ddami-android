package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfo(
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
    val myPieces: List<MyPiece>,
    @SerializedName("student")
    val student: Student,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)