package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfoX(
    @SerializedName("follow")
    val follow: Int,
    @SerializedName("followerCount")
    val followerCount: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("likeField")
    val likeField: List<Any>,
    @SerializedName("myPieces")
    val myPieces: List<MyPieceX>,
    @SerializedName("student")
    val student: Student,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)