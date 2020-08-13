package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyPiece(
    @SerializedName("description")
    val description: String,
    @SerializedName("fileUrl")
    val fileUrl: List<String>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("like")
    val like: List<Any>,
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("views")
    val views: Int
)