package com.example.quwi.feature_authentication.data.entity.response

import com.google.gson.annotations.SerializedName

data class CompanyResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("logo_url")
    val logoUrl: String?,
    @SerializedName("owner_fullname")
    val ownerFullName: String?
)