package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class DetailPieceAuthorDAO(
    @SerializedName("_id")
    val id: String,
    @SerializedName("userId")
    val userId: String

)