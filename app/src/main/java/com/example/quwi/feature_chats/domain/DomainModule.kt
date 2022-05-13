package com.example.quwi.feature_chats.domain

import com.example.quwi.core.di.DispatchersName
import com.example.quwi.feature_chats.domain.usecase.ChatsUseCase
import com.example.quwi.feature_chats.domain.usecase.LogoutUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    single { ChatsUseCase(coroutineDispatcher = get(qualifier = named(DispatchersName.IO)), chatsRepository = get()) }
    single { LogoutUseCase(logInRepository = get()) }
}
