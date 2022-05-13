package com.example.quwi.feature_authentication.data.entity.response

import com.google.gson.annotations.SerializedName

data class UserTokenResponse(
    @SerializedName("token")
    val token: String?
)