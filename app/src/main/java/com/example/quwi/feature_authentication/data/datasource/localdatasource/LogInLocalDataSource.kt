package com.example.quwi.feature_authentication.data.datasource.localdatasource

interface LogInLocalDataSource {
    fun getUserToken(): String
    fun saveUserToken(token: String)
    fun logout()
}