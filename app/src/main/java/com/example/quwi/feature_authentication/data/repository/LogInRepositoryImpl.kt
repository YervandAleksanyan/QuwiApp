package com.example.quwi.feature_authentication.data.repository

import com.example.quwi.feature_authentication.data.datasource.localdatasource.LogInLocalDataSource
import com.example.quwi.feature_authentication.data.datasource.remotedatasource.LogInRemoteDataSource
import com.example.quwi.feature_authentication.data.entity.projectentity.CompanyEntity
import com.example.quwi.feature_authentication.data.entity.projectentity.UserDataEntity
import com.example.quwi.feature_authentication.data.entity.projectentity.UserInfoEntity
import com.example.quwi.feature_authentication.data.entity.projectentity.UserTokenEntity
import com.example.quwi.feature_authentication.data.entity.response.UserEntityResponse

class LogInRepositoryImpl(
    private val logInLocalDataSource: LogInLocalDataSource,
    private val logInRemoteDataSource: LogInRemoteDataSource
) : LogInRepository {
    override fun getUserToken(): String = logInLocalDataSource.getUserToken()

    override fun saveUserToken(token: String) = logInLocalDataSource.saveUserToken(token)

    override fun logout() {
        logInLocalDataSource.logout()
    }

    override suspend fun logIn(email: String, password: String): UserTokenEntity =
        UserTokenEntity(token = logInRemoteDataSource.logIn(email, password).token ?: "")

    override suspend fun authenticateUser(): UserInfoEntity {

        val userResponse = logInRemoteDataSource.authenticateUser().user ?: UserEntityResponse()
        val companiesResponse = logInRemoteDataSource.authenticateUser().companies
        val userDataEntity =
            UserDataEntity(
                id = userResponse.id ?: 0,
                name = userResponse.name ?: "",
                isOnline = userResponse.isOnline ?: 0,
                companyId = userResponse.companyId ?: 0,
                nick = userResponse.nick ?: "",
                imageUrl = userResponse.imageUrl ?: ""
            )
        val companiesEntity =
            companiesResponse?.map {
                CompanyEntity(
                    id = it.id ?: 0,
                    uid = it.uid ?: "",
                    name = it.name ?: "",
                    logoUrl = it.logoUrl ?: "",
                    ownerFullName = it.ownerFullName ?: ""
                )
            }

        return UserInfoEntity(
            userDataEntity,
            companiesEntity ?: emptyList()
        )
    }

}
