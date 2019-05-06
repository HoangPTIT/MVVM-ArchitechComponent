package com.example.hdev.mvvm_demo.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") var id: String,
    @SerializedName("employee_name") val employee_name: String,
    @SerializedName("employee_salary") var employee_salary: String,
    @SerializedName("employee_age") var employee_age: String,
    @SerializedName("profile_image") var profile_image: String
)
