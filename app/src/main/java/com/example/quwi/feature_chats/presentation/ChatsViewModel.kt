package com.example.quwi.feature_chats.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quwi.feature_chats.data.entity.projectentity.ChannelEntity
import com.example.quwi.feature_chats.domain.usecase.ChatsUseCase
import kotlinx.coroutines.launch
import com.example.quwi.core.model.Result
import com.example.quwi.core.restservice.ErrorMapper
import com.example.quwi.core.viewmodel.SingleLiveEventData
import com.example.quwi.feature_chats.domain.usecase.LogoutUseCase

class ChatsViewModel(
    private val chatsUseCase: ChatsUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    private val _chatsListener = MutableLiveData<List<ChannelEntity>>()
    val chatsListener: LiveData<List<ChannelEntity>> = _chatsListener

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    val logoutEvent = SingleLiveEventData<Unit>()

    private val _errorMessageListener = MutableLiveData<String>()
    val errorMessageListener: LiveData<String> = _errorMessageListener

    fun listChats() {
        _isLoading.value = true
        viewModelScope.launch {
            when (val resource = chatsUseCase.invoke(Unit)) {
                is Result.Success -> {
                    _isLoading.value = false
                    _chatsListener.postValue(resource.data.orEmpty())
                }
                is Result.Error -> {
                    _isLoading.value = false
                    _errorMessageListener.value = ErrorMapper.map(resource.error)
                }
            }
        }
    }

    fun logout() {
        logoutUseCase.invoke(Unit)
        logoutEvent.value = Unit
    }

}