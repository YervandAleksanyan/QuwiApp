package com.example.quwi.feature_authentication.domain

import com.example.quwi.core.di.DispatchersName
import com.example.quwi.feature_authentication.domain.usecase.authentification.AuthenticationUseCase
import com.example.quwi.feature_authentication.domain.usecase.authentification.IsAuthenticatedUseCase
import com.example.quwi.feature_authentication.domain.usecase.login.LogInUseCase
import com.example.quwi.feature_authentication.domain.usecase.token.SetTokenUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module



val domainModule = module {
    single { LogInUseCase(logInRepository = get(), get(qualifier = named(DispatchersName.IO))) }

    single { SetTokenUseCase(logInRepository = get()) }

    single { IsAuthenticatedUseCase(logInRepository = get()) }

    single { AuthenticationUseCase(coroutineDispatcher = get(qualifier = named(DispatchersName.IO)), logInRepository = get()) }
}