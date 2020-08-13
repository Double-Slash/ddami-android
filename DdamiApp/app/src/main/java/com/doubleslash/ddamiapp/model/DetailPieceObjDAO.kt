package com.doubleslash.ddamiapp.model

import com.google.gson.annotations.SerializedName

data class DetailPieceObjDAO(
        val __v: Int,

        @SerializedName("_id")
        val FileId: String,

        val author: DetailPieceAuthorDAO,
        val comments: List<Any>,
        val created: String,
        val description: String,
        val fileUrl: List<String>,
        val hasField: List<String>,
        val like: List<String>,
        val likeByUser: Boolean,
        val likeCount: Int,
        val state: Int,
        val title: String,
        val views: Int

)