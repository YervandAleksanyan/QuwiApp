package com.example.quwi.feature_authentication.domain.usecase.authentification

import com.example.quwi.feature_authentication.data.entity.projectentity.UserInfoEntity
import com.example.quwi.feature_authentication.data.repository.LogInRepository
import com.example.quwi.core.usecase.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher

class AuthenticationUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val logInRepository: LogInRepository
) : CoroutineUseCase<Unit, UserInfoEntity>(coroutineDispatcher) {

    override suspend fun execute(
        parameters: Unit
    ): UserInfoEntity = logInRepository.authenticateUser()

}