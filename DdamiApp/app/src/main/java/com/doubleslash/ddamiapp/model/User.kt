package com.doubleslash.ddamiapp.model

data class User(
    val _id: String,
    val follow: Int,
    val follower: Int,
    val imageUrl: String,
    val likeField: List<String>,
    val myPieces: List<MyPiece>,
    val state: Boolean,
    val stateMessage: String,
    val userName: String
)