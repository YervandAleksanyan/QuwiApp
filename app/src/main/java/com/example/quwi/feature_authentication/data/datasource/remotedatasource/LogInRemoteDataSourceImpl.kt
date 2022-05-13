package com.example.quwi.feature_authentication.data.datasource.remotedatasource

import com.example.quwi.feature_authentication.data.entity.response.UserInfoResponse
import com.example.quwi.feature_authentication.data.entity.response.UserTokenResponse
import com.example.quwi.core.restservice.QuwiRestService
import com.example.quwi.feature_authentication.data.entity.request.LoginRequestBody

class LogInRemoteDataSourceImpl(private val quwiRestService: QuwiRestService) :
    LogInRemoteDataSource {

    override suspend fun logIn(
        email: String,
        password: String
    ): UserTokenResponse = quwiRestService
        .logIn(LoginRequestBody(email, password))

    override suspend fun authenticateUser(): UserInfoResponse = quwiRestService.authenticateUser()

}