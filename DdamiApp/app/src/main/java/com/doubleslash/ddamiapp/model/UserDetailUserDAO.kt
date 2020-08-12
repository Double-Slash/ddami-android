package com.doubleslash.ddamiapp.model

data class UserDetailUserDAO(
        val _id: String,
        val follow: Int,
        val follower: Int,
        val imageUrl: String,
        val likeField: List<String>,
        val myPieces: List<UserDetailMyPieceDAO>,
        val state: Boolean,
        val stateMessage: String,
        val userName: String
)