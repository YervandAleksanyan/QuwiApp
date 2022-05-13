package com.example.quwi.starter

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val starterModule = module {
    viewModel {
        StarterViewModel(
            isAuthenticatedUseCase = get(),
        )
    }
}