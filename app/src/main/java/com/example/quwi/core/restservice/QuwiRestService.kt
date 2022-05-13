package com.example.quwi.core.restservice

import com.example.quwi.feature_authentication.data.entity.request.LoginRequestBody
import com.example.quwi.feature_authentication.data.entity.response.UserInfoResponse
import com.example.quwi.feature_authentication.data.entity.response.UserTokenResponse
import com.example.quwi.feature_chats.data.entity.response.ChannelListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuwiRestService {

    @POST(LOG_IN_ENDPOINT)
    suspend fun logIn(
        @Body loginRequestBody: LoginRequestBody
    ): UserTokenResponse

    @GET(AUTHENTICATION_ENDPOINT)
    suspend fun authenticateUser(): UserInfoResponse

    @GET(CHANNELS_ENDPOINT)
    suspend fun getChannelsList(): ChannelListResponse
}