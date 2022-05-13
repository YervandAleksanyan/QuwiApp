package com.example.quwi.feature_chats.data.entity.projectentity

import com.example.quwi.feature_authentication.data.entity.projectentity.UserDataEntity

data class LastMessageEntity (
    val user: UserDataEntity = UserDataEntity(),
    val text: String = "",
    val sendTime: String = "",
    val isRead: Byte = 0
        )