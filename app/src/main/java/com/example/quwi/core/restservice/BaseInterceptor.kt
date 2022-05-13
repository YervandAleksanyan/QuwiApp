package com.example.quwi.core.restservice

import com.example.quwi.core.timezone.TimeZoneProvider
import okhttp3.Interceptor

class BaseInterceptor(private val timeZoneProvider: TimeZoneProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE)
            .addHeader(CLIENT_DEVICE, DEVICE)
            .addHeader(CLIENT_TIME_ZONE, timeZoneProvider.getTimeZone())
            .build()
        return chain.proceed(request)
    }
}