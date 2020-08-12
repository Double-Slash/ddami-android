package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfo(
    @SerializedName("_id")
    var id: String,
    @SerializedName("imageUrl")
    var imageUrl: String,
    @SerializedName("userName")
    var userName: String
)