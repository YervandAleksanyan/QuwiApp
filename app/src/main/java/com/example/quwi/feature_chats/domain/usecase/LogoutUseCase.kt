package com.example.quwi.feature_chats.domain.usecase

import com.example.quwi.core.usecase.UseCase
import com.example.quwi.feature_authentication.data.repository.LogInRepository

class LogoutUseCase(private val logInRepository: LogInRepository) : UseCase<Unit, Unit>() {

    override fun execute(parameters: Unit) {
        logInRepository.logout()
    }

}