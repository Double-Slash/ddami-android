package com.doubleslash.ddamiapp.model

data class ProductXX(
    val _id: String,
    val author: AuthorX,
    val description: String,
    val hasField: List<String>,
    val like: List<String>,
    val likeByUser: Boolean,
    val locationName: String,
    val price: Int,
    val title: String
)