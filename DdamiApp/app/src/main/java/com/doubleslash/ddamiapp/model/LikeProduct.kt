package com.doubleslash.ddamiapp.model

data class LikeProduct(
    val _id: String,
    val created: String,
    val fileUrl: List<String>,
    val locationName: String,
    val pieces: List<PieceX>,
    val state: Int,
    val title: String
)