package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyLikeListDAO(
        @SerializedName("likes")
    val likes: List<MyLikeListItemDAO>,
        @SerializedName("result")
    val result: Int
)