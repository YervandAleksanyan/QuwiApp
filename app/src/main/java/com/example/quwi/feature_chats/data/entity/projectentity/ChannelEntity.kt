package com.example.quwi.feature_chats.data.entity.projectentity

data class ChannelEntity(
    val id: Int = 0,
    val type: String = "",
    val pinToTop: Boolean = false ,
    val lastMessage: LastMessageEntity = LastMessageEntity(),
    val isMessageUnread: Boolean = false,
    val dta_change_msg: String = ""
)