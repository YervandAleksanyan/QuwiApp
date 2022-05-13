package com.example.quwi.feature_authentication.data

import com.example.quwi.feature_authentication.data.datasource.localdatasource.LogInLocalDataSource
import com.example.quwi.feature_authentication.data.datasource.localdatasource.LogInLocalDataSourceImpl
import com.example.quwi.feature_authentication.data.datasource.remotedatasource.LogInRemoteDataSource
import com.example.quwi.feature_authentication.data.datasource.remotedatasource.LogInRemoteDataSourceImpl
import com.example.quwi.feature_authentication.data.repository.LogInRepository
import com.example.quwi.feature_authentication.data.repository.LogInRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<LogInLocalDataSource> { LogInLocalDataSourceImpl(sharedPreferences = get()) }

    single<LogInRepository> {
        LogInRepositoryImpl(
            logInLocalDataSource = get(),
            logInRemoteDataSource = get()
        )
    }

    single<LogInRemoteDataSource> { LogInRemoteDataSourceImpl(quwiRestService = get()) }

}
