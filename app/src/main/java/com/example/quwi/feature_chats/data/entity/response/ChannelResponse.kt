package com.example.quwi.feature_chats.data.entity.response

import com.google.gson.annotations.SerializedName

data class ChannelResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("pin_to_top")
    val pinToTop: Boolean?,
    @SerializedName("message_last")
    val lastMessage: LastMessageResponse = LastMessageResponse(),
    @SerializedName("is_unread_manual")
    val isMessageUnread: Boolean?,
    @SerializedName("dta_change_msg")
    val dta_change_msg: String?
)