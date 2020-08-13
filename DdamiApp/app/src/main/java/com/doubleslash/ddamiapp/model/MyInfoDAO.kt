package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class MyInfoDAO(
    @SerializedName("myInfo")
    val myInfo: MyInfoX,
    @SerializedName("result")
    val result: Int
)