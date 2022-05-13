package com.example.quwi.feature_chats.data.entity.response

import com.google.gson.annotations.SerializedName

data class ChannelListResponse(
    @SerializedName("channels")
    val channels: List<ChannelResponse>? = emptyList()
)