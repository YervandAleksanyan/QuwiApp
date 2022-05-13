package com.example.quwi.feature_authentication.presentation

import com.example.quwi.feature_authentication.presentation.login.LogInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        LogInViewModel(
            logInUseCase = get(),
            authenticationUseCase = get(),
            setTokenUseCase = get()
        )
    }
}