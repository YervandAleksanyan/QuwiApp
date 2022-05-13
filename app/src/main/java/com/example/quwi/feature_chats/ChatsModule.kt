package com.example.quwi.feature_chats

import com.example.quwi.feature_chats.data.dataModule
import com.example.quwi.feature_chats.domain.domainModule
import com.example.quwi.feature_chats.presentation.presentationModule


val chatsModule = dataModule + domainModule + presentationModule