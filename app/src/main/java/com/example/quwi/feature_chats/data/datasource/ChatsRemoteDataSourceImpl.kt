package com.example.quwi.feature_chats.data.datasource

import com.example.quwi.feature_chats.data.entity.response.ChannelListResponse
import com.example.quwi.core.restservice.QuwiRestService

class ChatsRemoteDataSourceImpl(private val quwiRestService: QuwiRestService): ChatsRemoteDataSource {
    override suspend fun getChats(): ChannelListResponse =
        quwiRestService.getChannelsList()
}