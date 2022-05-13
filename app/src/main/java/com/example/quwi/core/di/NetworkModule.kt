package com.example.quwi.core.di

import com.example.quwi.BuildConfig
import com.example.quwi.core.restservice.BaseInterceptor
import com.example.quwi.core.restservice.BasicAuthInterceptor
import com.example.quwi.core.restservice.QuwiRestService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { getHttpLoggingInterceptor() }

    single { getOkHttpClient(httpLoggingInterceptor = get(), baseInterceptor = get(), basicAuthInterceptor = get()) }

    single { getRetrofit(okHttpClient = get(), baseUrl = BuildConfig.BASE_URL) }

    single { getQuwiRestService(retrofit = get()) }

    single { BasicAuthInterceptor(logInLocalDataSource = get()) }

    single { BaseInterceptor(timeZoneProvider = get()) }
}

private fun getRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit
    .Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()

private fun getQuwiRestService(retrofit: Retrofit): QuwiRestService =
    retrofit.create(QuwiRestService::class.java)

private fun getOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    baseInterceptor: BaseInterceptor,
    basicAuthInterceptor: BasicAuthInterceptor
): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(httpLoggingInterceptor)
    .addInterceptor(baseInterceptor)
    .addInterceptor(basicAuthInterceptor)
    .build()

private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = if (BuildConfig.DEBUG)
        HttpLoggingInterceptor.Level.BODY
    else
        HttpLoggingInterceptor.Level.NONE
    return loggingInterceptor
}
