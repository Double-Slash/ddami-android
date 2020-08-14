package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class DetailPieceCommentDAO(
    @SerializedName("comments")
    val comments: List<String>,
    @SerializedName("content")
    val content: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("user")
    val user: DetailPieceUserDAO
)