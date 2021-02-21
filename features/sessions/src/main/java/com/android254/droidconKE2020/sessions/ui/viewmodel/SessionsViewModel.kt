package com.android254.droidconKE2020.sessions.ui.viewmodel

import androidx.lifecycle.*
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SessionsViewModel(private val sessionsRepository: SessionRepository) : ViewModel() {
    private var _sessions = MutableLiveData<List<SessionUIModel>>()
    val sessions get() = _sessions

    private var _sessionUIModel = MutableLiveData<SessionUIModel>()
    val sessionUIModel get() = _sessionUIModel

    val showToast = SingleLiveEvent<String>()
    val isSessionBookmarked = SingleLiveEvent<String>()

    var showBookMarkedSessionsPair = MutableLiveData(false to "Day 1")
    val filteredSessions = showBookMarkedSessionsPair.switchMap { aPair ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(fetchSessions(aPair))
        }
    }

    suspend fun fetchSessions(apair: Pair<Boolean, String>): List<SessionUIModel>{
        val sessions = mutableListOf<SessionUIModel>()
        val day = apair.second
        val showBookmarked = apair.first
        when (val value = sessionsRepository.fetchSessionsSchedule(day)) {
            is Data.Success -> {
               if (showBookmarked){
                   sessions.addAll(value.data.filter { sessionUIModel -> sessionUIModel.isBookmarked  })
                }else{

                 sessions.addAll(value.data)
                }
            }
            is Data.Error -> {
                showToast.postValue(value.exception.toString())
            }
        }
        return sessions
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