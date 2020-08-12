package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class Piece(
    @SerializedName("author")
    var author: Author,
    @SerializedName("description")
    var description: String,
    @SerializedName("fileUrl")
    var fileUrl: List<String>,
    @SerializedName("_id")
    var id: String,
    @SerializedName("like")
    var like: List<Any>,
    @SerializedName("likeByMe")
    var likeByMe: Boolean,
    @SerializedName("likeCount")
    var likeCount: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("views")
    var views: Int
)