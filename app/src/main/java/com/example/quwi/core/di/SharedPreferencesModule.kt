package com.example.quwi.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.quwi.feature_authentication.data.constants.SHARED_PREF
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single { getSharedPrefs(androidApplication()) }
}

private fun getSharedPrefs(androidApplication: Application): SharedPreferences {
    return androidApplication.getSharedPreferences(
        SHARED_PREF,
        Context.MODE_PRIVATE
    )
}