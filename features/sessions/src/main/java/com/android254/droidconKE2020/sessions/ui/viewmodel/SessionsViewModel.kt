package com.android254.droidconKE2020.sessions.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import kotlinx.coroutines.launch

class SessionsViewModel(private val sessionsRepository: SessionRepository) : ViewModel() {
    private var _sessions = MutableLiveData<List<SessionUIModel>>()
    val sessions get() = _sessions

    private var _sessionUIModel = MutableLiveData<SessionUIModel>()
    val sessionUIModel get() = _sessionUIModel

    val showToast = SingleLiveEvent<String>()
    val isSessionBookmarked = SingleLiveEvent<String>()

    private val localSessions = mutableListOf<SessionUIModel>()

    var showBookmarked = false

    suspend fun fetchSessions(day: String) {
        if (localSessions.isEmpty()) {
            when (val value = sessionsRepository.fetchSessionsSchedule(day)) {
                is Data.Success -> {
                    localSessions.addAll(value.data)
                }
                is Data.Error -> {
                    showToast.postValue(value.exception.toString())
                }
            }
        }


        if (showBookmarked) {
            _sessions.value = localSessions.filter { sessionUIModel -> sessionUIModel.isBookmarked }
        } else {
            _sessions.value = localSessions
        }
    }

    fun setSession(sessionUIModel: SessionUIModel) {
        _sessionUIModel.value = sessionUIModel
    }

    fun changeBookmarkStatus(sessionId: Int) {
        viewModelScope.launch {

            when (val value = sessionsRepository.changeBookmarkStatus(sessionId)) {
                is Data.Success -> isSessionBookmarked.postValue(value.data)
                is Data.Error -> isSessionBookmarked.postValue(value.exception.toString())
            }
        }
    }
}