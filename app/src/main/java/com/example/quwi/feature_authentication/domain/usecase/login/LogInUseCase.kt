package com.example.quwi.feature_authentication.domain.usecase.login

import com.example.quwi.feature_authentication.data.entity.projectentity.UserTokenEntity
import com.example.quwi.feature_authentication.data.repository.LogInRepository
import com.example.quwi.feature_authentication.domain.model.UserCredentialsModel
import com.example.quwi.core.usecase.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher

class LogInUseCase(
    private val logInRepository: LogInRepository,
    coroutineDispatcher: CoroutineDispatcher
) : CoroutineUseCase<UserCredentialsModel, UserTokenEntity>(coroutineDispatcher) {

    override suspend fun execute(parameters: UserCredentialsModel): UserTokenEntity {
        return logInRepository.logIn(parameters.email, parameters.password)
    }
}