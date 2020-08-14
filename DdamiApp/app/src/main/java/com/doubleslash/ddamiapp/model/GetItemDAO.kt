package com.doubleslash.ddamiapp.model

data class GetItemDAO(
    val likeProducts: List<LikeProduct>,
    val result: Int
)