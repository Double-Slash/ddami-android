package com.doubleslash.ddamiapp.model

data class UserDetailMyPieceDAO(
    val _id: String,
    val description: String,
    val fileUrl: List<String>,
    val like: List<Any>,
    val likeCount: Int,
    val title: String,
    val views: Int
)