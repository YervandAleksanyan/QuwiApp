package com.example.quwi.feature_chats.data

import com.example.quwi.feature_chats.data.datasource.ChatsRemoteDataSource
import com.example.quwi.feature_chats.data.datasource.ChatsRemoteDataSourceImpl
import com.example.quwi.feature_chats.data.repository.ChatsRepository
import com.example.quwi.feature_chats.data.repository.ChatsRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<ChatsRemoteDataSource> { ChatsRemoteDataSourceImpl(quwiRestService = get()) }
    single<ChatsRepository> { ChatsRepositoryImpl(get()) }
}