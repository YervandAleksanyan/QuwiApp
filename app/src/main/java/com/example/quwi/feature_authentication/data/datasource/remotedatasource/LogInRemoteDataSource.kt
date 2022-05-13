package com.example.quwi.feature_authentication.data.datasource.remotedatasource

import com.example.quwi.feature_authentication.data.entity.response.UserInfoResponse
import com.example.quwi.feature_authentication.data.entity.response.UserTokenResponse

interface LogInRemoteDataSource {
    suspend fun logIn(email: String, password: String): UserTokenResponse

    suspend fun authenticateUser(): UserInfoResponse
}