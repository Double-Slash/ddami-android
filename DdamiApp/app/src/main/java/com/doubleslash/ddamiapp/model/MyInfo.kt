package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfo(
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("userName")
    val userName: String
)