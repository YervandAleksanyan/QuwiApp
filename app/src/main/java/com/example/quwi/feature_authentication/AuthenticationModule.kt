package com.example.quwi.feature_authentication

import com.example.quwi.feature_authentication.data.dataModule
import com.example.quwi.feature_authentication.domain.domainModule
import com.example.quwi.feature_authentication.presentation.presentationModule


val authenticationModule = dataModule + domainModule + presentationModule