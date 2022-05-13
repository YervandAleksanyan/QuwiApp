package com.example.quwi.feature_authentication.data.entity.projectentity

data class UserInfoEntity(
    val user: UserDataEntity = UserDataEntity(),
    val companies: List<CompanyEntity> = emptyList()
)
