package com.example.quwi.feature_authentication.data.entity.response

import com.google.gson.annotations.SerializedName

data class UserEntityResponse(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nick")
    val nick: String? = "",
    @SerializedName("is_online")
    val isOnline: Byte? = 0,
    @SerializedName("id_company")
    val companyId: Int? = 0,
    @SerializedName("avatar_url")
    val imageUrl: String? = ""
)