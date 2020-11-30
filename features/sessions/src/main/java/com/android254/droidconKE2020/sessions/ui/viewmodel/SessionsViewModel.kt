package com.android254.droidconKE2020.sessions.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.models.Sessions
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.sessions.models.DaySession
import kotlinx.coroutines.launch

class SessionsViewModel(private val sessionsRepository: SessionRepository) : ViewModel() {
    private var _sessionsSchedule = MutableLiveData<Data<Sessions>>()
    val sessionsSchedule get() = _sessionsSchedule


    fun fetchSessionsSchedule(){
        viewModelScope.launch {
            _sessionsSchedule.postValue(sessionsRepository.fetchSessionsSchedule())
        }
    }

}