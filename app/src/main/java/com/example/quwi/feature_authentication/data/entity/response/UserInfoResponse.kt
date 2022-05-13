package com.example.quwi.feature_authentication.data.entity.response

import com.google.gson.annotations.SerializedName

data class UserInfoResponse(
    @SerializedName("user")
    val user: UserEntityResponse?,
    @SerializedName("companies")
    val companies: List<CompanyResponse>?
)