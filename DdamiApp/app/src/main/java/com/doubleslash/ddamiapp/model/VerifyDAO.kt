package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class VerifyDAO(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: Int
)