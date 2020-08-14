package com.doubleslash.ddamiapp.model

data class ProductX(
    val _id: String,
    val fileUrl: List<String>,
    val hasField: List<Any>,
    val like: List<String>,
    val likeByMe: Boolean,
    val likeCount: Int,
    val locationName: String,
    val price: Int,
    val state: Int,
    val title: String,
    val views: Int
)