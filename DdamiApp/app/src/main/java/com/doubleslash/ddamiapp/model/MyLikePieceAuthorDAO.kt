package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyLikePieceAuthorDAO(
        @SerializedName("_id")
        val id: String,
        @SerializedName("userId")
        val userId: String,
        @SerializedName("userName")
        val userName: String
)