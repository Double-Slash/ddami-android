package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class LikeProduct(
    @SerializedName("created")
    val created: String,
    @SerializedName("fileUrl")
    val fileUrl: List<String>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("locationName")
    val locationName: String,
    @SerializedName("pieces")
    val pieces: List<PieceXX>,
    @SerializedName("state")
    val state: Int,
    @SerializedName("title")
    val title: String
)