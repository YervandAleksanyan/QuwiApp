package com.example.quwi.feature_authentication.domain.usecase.token

import com.example.quwi.feature_authentication.data.repository.LogInRepository

class SetTokenUseCase(private val logInRepository: LogInRepository) {
    fun setToken(token: String) = logInRepository.saveUserToken(token)
}