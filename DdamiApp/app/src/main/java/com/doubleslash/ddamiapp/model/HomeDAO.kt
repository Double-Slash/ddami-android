package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class HomeDAO(
    @SerializedName("pieces")
    var pieces: List<Piece>,
    @SerializedName("result")
    var result: Int
)