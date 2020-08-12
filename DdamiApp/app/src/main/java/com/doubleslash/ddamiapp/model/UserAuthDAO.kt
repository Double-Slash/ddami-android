package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class UserAuthDAO(
    @SerializedName("myInfo")
    var myInfo: MyInfo,
    @SerializedName("result")
    var result: Int
)