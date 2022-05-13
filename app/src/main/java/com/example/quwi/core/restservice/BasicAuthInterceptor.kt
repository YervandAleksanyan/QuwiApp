package com.example.quwi.core.restservice

import com.example.quwi.feature_authentication.data.datasource.localdatasource.LogInLocalDataSource
import okhttp3.Interceptor

class BasicAuthInterceptor(private val logInLocalDataSource: LogInLocalDataSource) : Interceptor {

    companion object {
        private const val BEARER_PREFIX = "Bearer"
    }

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(AUTHORIZATION, "$BEARER_PREFIX ${logInLocalDataSource.getUserToken()}")
            .build()
        return chain.proceed(request)
    }
}