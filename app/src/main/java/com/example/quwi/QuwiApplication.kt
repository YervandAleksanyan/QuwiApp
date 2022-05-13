package com.example.quwi

import android.app.Application
import com.example.quwi.core.coreModule
import com.example.quwi.feature_authentication.authenticationModule
import com.example.quwi.feature_chats.chatsModule
import com.example.quwi.starter.starterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuwiApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@QuwiApplication)
            modules(coreModule + authenticationModule + chatsModule + starterModule)
        }
    }
}