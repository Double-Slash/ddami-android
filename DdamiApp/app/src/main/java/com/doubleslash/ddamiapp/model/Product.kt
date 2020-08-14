package com.doubleslash.ddamiapp.model

data class Product(
    val _id: String,
    val hasField: List<String>,
    val like: List<Any>,
    val likeByMe: Boolean,
    val likeCount: Int,
    val locationName: String,
    val pieces: List<Piece>,
    val price: Int,
    val state: Int,
    val title: String,
    val views: Int
)