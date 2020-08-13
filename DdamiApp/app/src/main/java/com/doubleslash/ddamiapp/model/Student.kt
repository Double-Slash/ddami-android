package com.doubleslash.ddamiapp.model


import com.google.gson.annotations.SerializedName

data class Student(
        @SerializedName("department")
        val department: String,
        @SerializedName("_id")
        val id: String,
        @SerializedName("university")
        val university: String
)