package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class DetailPieceObjDAO(
        @SerializedName("author")
    val author: DetailPieceAuthorDAO,
        @SerializedName("comments")
    val comments: List<DetailPieceCommentDAO>,
        @SerializedName("created")
    val created: String,
        @SerializedName("description")
    val description: String,
        @SerializedName("fileUrl")
    val fileUrl: List<String>,
        @SerializedName("hasField")
    val hasField: List<String>,
        @SerializedName("_id")
    val FileId: String,
        @SerializedName("like")
    val like: List<String>,
        @SerializedName("likeByUser")
    val likeByUser: Boolean,
        @SerializedName("likeCount")
    val likeCount: Int,
        @SerializedName("state")
    val state: Int,
        @SerializedName("title")
    val title: String,
        @SerializedName("__v")
    val v: Int,
        @SerializedName("views")
    val views: Int
)