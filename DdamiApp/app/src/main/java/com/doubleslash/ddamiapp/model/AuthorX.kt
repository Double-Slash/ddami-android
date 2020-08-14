package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class AuthorX(
    @SerializedName("followByMe")
    val followByMe: Boolean,
    @SerializedName("follower")
    val follower: List<Any>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("likeField")
    val likeField: List<String>,
    @SerializedName("stateMessage")
    val stateMessage: String,
    @SerializedName("userId")
    val userId: String
)