package com.example.quwi.feature_authentication.data.entity.request

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)