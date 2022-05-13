package com.example.quwi.feature_authentication.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quwi.core.model.Result
import com.example.quwi.core.restservice.ErrorMapper
import com.example.quwi.core.viewmodel.SingleLiveEventData
import com.example.quwi.feature_authentication.domain.model.UserCredentialsModel
import com.example.quwi.feature_authentication.domain.usecase.authentification.AuthenticationUseCase
import com.example.quwi.feature_authentication.domain.usecase.login.LogInUseCase
import com.example.quwi.feature_authentication.domain.usecase.token.SetTokenUseCase
import kotlinx.coroutines.launch

class LogInViewModel(
    private val logInUseCase: LogInUseCase,
    private val authenticationUseCase: AuthenticationUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel() {

    val isLoginSucceed = SingleLiveEventData<Unit>()

    val isLoading = SingleLiveEventData<Boolean>()

    val isLoginFailed = SingleLiveEventData<String>()

    fun logIn(email: String, password: String) {
        isLoading.value = true
        viewModelScope.launch {
            when (val response = logInUseCase.invoke(UserCredentialsModel(email, password))) {
                is Result.Success -> {
                    isLoading.value = false
                    setTokenUseCase.setToken(response.data.token)
                    authenticateUser()
                }
                is Result.Error -> {
                    isLoading.value = false
                    isLoginFailed.value = ErrorMapper.map(response.error)
                }
            }
        }
    }

    private fun authenticateUser() {
        viewModelScope.launch {
            when (val response = authenticationUseCase.invoke(Unit)) {
                is Result.Success -> isLoginSucceed.value = Unit
                is Result.Error -> isLoginFailed.value = ErrorMapper.map(response.error)
            }
        }
    }

    fun fieldsAreEmpty(
        email: String,
        password: String
    ) = !(email.isNotEmpty() && password.isNotEmpty())

}