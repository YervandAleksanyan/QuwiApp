package com.example.quwi.core.di

import com.example.quwi.core.timezone.TimeZoneProvider
import com.example.quwi.core.timezone.TimeZoneProviderImpl
import org.koin.dsl.module

val timeZoneModule = module {
    single<TimeZoneProvider> { TimeZoneProviderImpl() }
}