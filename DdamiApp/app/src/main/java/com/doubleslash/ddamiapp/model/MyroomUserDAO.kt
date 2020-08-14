package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyroomUserDAO(
        @SerializedName("result")
        val result: Int,
        @SerializedName("user")
        val user: User
)