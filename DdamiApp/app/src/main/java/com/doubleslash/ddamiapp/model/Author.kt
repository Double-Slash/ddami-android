package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("_id")
    var id: String,
    @SerializedName("userId")
    var userId: String,
    @SerializedName("imageUrl")
    var imageUrl: String
)