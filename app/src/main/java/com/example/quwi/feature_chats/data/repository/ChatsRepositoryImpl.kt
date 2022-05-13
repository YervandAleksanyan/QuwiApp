package com.example.quwi.feature_chats.data.repository

import com.example.quwi.feature_chats.data.datasource.ChatsRemoteDataSource
import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity
import com.example.quwi.feature_chats.data.mapper.CHANNEL_RESPONSE_TO_ENTITY

class ChatsRepositoryImpl(private val chatsRemoteDataSource: ChatsRemoteDataSource) :
    ChatsRepository {

    override suspend fun getChats(

    ): List<ChannelEntity> = CHANNEL_RESPONSE_TO_ENTITY
        .mapIfNotNull(chatsRemoteDataSource.getChats().channels)
        .orEmpty()

}