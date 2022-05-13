package com.example.quwi.feature_chats.data.datasource

import com.example.quwi.feature_chats.data.entity.response.ChannelListResponse

interface ChatsRemoteDataSource {
    suspend fun getChats(): ChannelListResponse
}