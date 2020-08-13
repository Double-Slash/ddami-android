package com.doubleslash.ddamiapp.model

data class DetailPieceObjDAO(
        val __v: Int,
        val _id: String,
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