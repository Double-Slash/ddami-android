package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfoX(
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("state")
    val state: Boolean,
    @SerializedName("student")
    val student: Student,
    @SerializedName("userName")
    val userName: String
)