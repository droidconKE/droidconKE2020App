package com.android254.droidconKE2020.sessions.ui.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.sessions.ui.views.models.DummySessionDetail

class SessionDetailViewModel : ViewModel() {

    private val _sessionDetails = MutableLiveData<DummySessionDetail>()
    val sessionDetails: LiveData<DummySessionDetail>
        get() = _sessionDetails
    private val _saveSession = MutableLiveData<DummySessionDetail>()
    val saveSession: LiveData<DummySessionDetail>
        get() = _saveSession
    private val _shareSession = MutableLiveData<DummySessionDetail>()
    val shareSession: LiveData<DummySessionDetail>
        get() = _shareSession
    private val _clickSpeaker = MutableLiveData<Int>()
    val clickSpeaker: LiveData<Int>
        get() = _clickSpeaker
    private val _navigateBack = MutableLiveData<Boolean>()
    val navigateBack: LiveData<Boolean>
        get() = _navigateBack

    fun getSessionDetails(sessionId: Long) {
        _sessionDetails.value = FakeRepository.getSession(sessionId)
    }

    fun onClickSaveSession(dummySessionDetail: DummySessionDetail) {
        _saveSession.value = dummySessionDetail
    }

    fun onSessionSaved() {
        _saveSession.value = null
    }

    fun onClickShareSession(dummySessionDetail: DummySessionDetail) {
        _shareSession.value = dummySessionDetail
    }

    fun onSessionShared() {
        _shareSession.value = null
    }

    fun onClickSpeaker(speakerId: Int) {
        _clickSpeaker.value = speakerId
    }

    fun onSpeakerClicked() {
        _clickSpeaker.value = null
    }

    fun onNavigateBack() {
        _navigateBack.value = true
    }

    fun onNavigatedBack() {
        _navigateBack.value = null
    }
}

object FakeRepository {
    fun getSession(sessionId: Long): DummySessionDetail {
        return DummySessionDetail(
            sessionDuration = "9:30 AM - 10:30 AM",
            sessionDescription = "A guide to asynchronous programming with Kotlin",
            sessionSpeakerImageURL = "https://media-exp1.licdn.com/dms/image/C5603AQGluIti7nsWtg/profile-displayphoto-shrink_200_200/0?e=1586995200&v=beta&t=XU8HzarrTlprLPMaNJ2nWMCvzICaiB38HPtBOZsYTcw",
            sessionSpeaker = "Jabez Magomere",
            sessionSpeakerDescription = "I eat dispatchers for breakfast and workout using coroutine builders",
            sessionSpeakerJob = "Software Engineer, Twiga Foods",
            sessionTargetType = "Intermediate",
            sessionTitle = "Kotlin Coroutines",
            sessionVenue = "ROOM 3"
        )
    }
}
