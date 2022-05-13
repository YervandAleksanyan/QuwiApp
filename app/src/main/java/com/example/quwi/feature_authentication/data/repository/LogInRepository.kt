package com.example.quwi.feature_authentication.data.repository

import com.example.quwi.feature_authentication.data.entity.projectentity.UserInfoEntity
import com.example.quwi.feature_authentication.data.entity.projectentity.UserTokenEntity

interface LogInRepository {
    fun getUserToken(): String
    fun saveUserToken(token: String)
    fun logout()
    suspend fun logIn(email: String, password: String): UserTokenEntity
    suspend fun authenticateUser(): UserInfoEntity
}