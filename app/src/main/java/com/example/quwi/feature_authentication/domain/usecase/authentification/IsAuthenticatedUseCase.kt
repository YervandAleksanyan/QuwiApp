package com.example.quwi.feature_authentication.domain.usecase.authentification

import com.example.quwi.core.usecase.UseCase
import com.example.quwi.feature_authentication.data.repository.LogInRepository

class IsAuthenticatedUseCase(
    private val logInRepository: LogInRepository
) : UseCase<Unit, Boolean>() {

    override fun execute(parameters: Unit): Boolean = logInRepository.getUserToken().isNotEmpty()

}