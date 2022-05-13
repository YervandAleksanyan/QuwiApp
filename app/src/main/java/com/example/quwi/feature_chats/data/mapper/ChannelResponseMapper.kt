package com.example.quwi.feature_chats.data.mapper

import com.example.quwi.core.mapper.Mapper
import com.example.quwi.feature_authentication.data.entity.projectentity.UserDataEntity
import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity
import com.example.quwi.feature_chats.data.entity.projectentity.LastMessageEntity
import com.example.quwi.feature_chats.data.entity.response.ChannelResponse
import com.example.quwi.feature_chats.data.entity.response.LastMessageResponse

private val LAST_MESSAGE_RESPONSE_TO_ENTITY =
    object : Mapper<LastMessageResponse, LastMessageEntity> {
        override fun map(s: LastMessageResponse): LastMessageEntity =
            LastMessageEntity(
                text = s.text ?: "",
                sendTime = s.sendTime ?: "",
                isRead = s.isRead ?: 0,
                user = UserDataEntity(
                    id = s.user?.id ?: 0,
                    name = s.user?.name ?: "",
                    isOnline = s.user?.isOnline ?: 0,
                    companyId = s.user?.companyId ?: 0,
                    nick = s.user?.nick ?: "",
                    imageUrl = s.user?.imageUrl ?: ""
                )
            )
    }

val CHANNEL_RESPONSE_TO_ENTITY = object : Mapper<ChannelResponse, ChannelEntity> {
    override fun map(s: ChannelResponse): ChannelEntity =
        ChannelEntity(
            id = s.id ?: 0,
            type = s.type ?: "",
            pinToTop = s.pinToTop ?: false,
            lastMessage = LAST_MESSAGE_RESPONSE_TO_ENTITY.map(
                s.lastMessage
            ),
            isMessageUnread = s.isMessageUnread ?: false,
            dta_change_msg = s.dta_change_msg ?: ""
        )
}