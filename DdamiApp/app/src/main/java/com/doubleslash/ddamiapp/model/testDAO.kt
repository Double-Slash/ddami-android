package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class testDAO(
    @SerializedName("likeProducts")
    val likeProducts: List<LikeProduct>,
    @SerializedName("result")
    val result: Int
)