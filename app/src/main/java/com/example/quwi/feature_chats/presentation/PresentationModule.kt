package com.example.quwi.feature_chats.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ChatsViewModel(chatsUseCase = get(), logoutUseCase = get()) }
}