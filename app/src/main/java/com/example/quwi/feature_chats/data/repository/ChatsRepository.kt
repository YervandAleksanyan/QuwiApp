package com.example.quwi.feature_chats.data.repository

import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity

interface ChatsRepository {
    suspend fun getChats(): List<ChannelEntity>
}