package com.example.quwi.core

import com.example.quwi.core.di.coroutineModule
import com.example.quwi.core.di.networkModule
import com.example.quwi.core.di.sharedPreferencesModule
import com.example.quwi.core.di.timeZoneModule

val coreModule = sharedPreferencesModule + coroutineModule + networkModule + timeZoneModule