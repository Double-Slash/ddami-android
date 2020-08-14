package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyLikeListItemDAO(
        @SerializedName("author")
        val author: MyLikePieceAuthorDAO,
        @SerializedName("fileUrl")
        val fileUrl: List<String>,
        @SerializedName("_id")
        val id: String,
        @SerializedName("title")
        val title: String
)