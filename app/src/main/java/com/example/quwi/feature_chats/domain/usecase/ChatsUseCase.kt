package com.example.quwi.feature_chats.domain.usecase

import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity
import com.example.quwi.feature_chats.data.repository.ChatsRepository
import com.example.quwi.core.usecase.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher

class ChatsUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val chatsRepository: ChatsRepository
) : CoroutineUseCase<Unit, List<ChannelEntity>>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit): List<ChannelEntity> = chatsRepository.getChats()

}