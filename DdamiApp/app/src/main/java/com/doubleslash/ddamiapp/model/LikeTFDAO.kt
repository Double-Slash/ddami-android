package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class LikeTFDAO(
        @SerializedName("message")
        val message: String,
        @SerializedName("result")
        val result: Int
)