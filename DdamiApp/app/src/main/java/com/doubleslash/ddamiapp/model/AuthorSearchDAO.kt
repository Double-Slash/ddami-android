package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class AuthorSearchDAO(
    @SerializedName("authors")
    val authors: List<AuthorX>,
    @SerializedName("result")
    val result: Int
)