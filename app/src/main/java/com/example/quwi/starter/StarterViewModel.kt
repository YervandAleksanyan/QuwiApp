package com.example.quwi.starter

import androidx.lifecycle.ViewModel
import com.example.quwi.core.viewmodel.SingleLiveEventData
import com.example.quwi.feature_authentication.domain.usecase.authentification.IsAuthenticatedUseCase

class StarterViewModel(
    private val isAuthenticatedUseCase: IsAuthenticatedUseCase
) : ViewModel() {

    val isAuthenticated = SingleLiveEventData<Boolean>()

    fun checkIsAuthenticated() {
        isAuthenticated.value = isAuthenticatedUseCase(Unit)
    }

}