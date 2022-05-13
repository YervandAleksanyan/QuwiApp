package com.example.quwi.feature_authentication.data.datasource.localdatasource

import android.content.SharedPreferences
import com.example.quwi.feature_authentication.data.constants.TOKEN

class LogInLocalDataSourceImpl(private val sharedPreferences: SharedPreferences) :
    LogInLocalDataSource {
    override fun getUserToken(): String = sharedPreferences.getString(TOKEN, "") ?: ""

    override fun saveUserToken(token: String) = sharedPreferences
        .edit()
        .putString(TOKEN, token)
        .apply()


    override fun logout() = sharedPreferences
        .edit()
        .clear()
        .apply()
}