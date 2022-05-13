package com.example.quwi.feature_chats.data.entity.response

import com.example.quwi.feature_authentication.data.entity.response.UserEntityResponse
import com.google.gson.annotations.SerializedName

data class LastMessageResponse (
    @SerializedName("user")
    val user: UserEntityResponse? = UserEntityResponse(),
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("dta_create")
    val sendTime: String? = "",
    @SerializedName("is_read")
    val isRead: Byte? = 0
)