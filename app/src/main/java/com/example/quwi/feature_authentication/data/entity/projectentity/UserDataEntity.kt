package com.example.quwi.feature_authentication.data.entity.projectentity

data class UserDataEntity(
    val id: Int = 0,
    val name: String = "",
    val isOnline: Byte = 0,
    val companyId: Int = 0,
    val nick: String = "",
    val imageUrl:String = ""
)