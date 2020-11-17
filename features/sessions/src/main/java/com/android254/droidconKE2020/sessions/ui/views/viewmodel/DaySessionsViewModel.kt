package com.android254.droidconKE2020.sessions.ui.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession

class DaySessionsViewModel : ViewModel() {
    val daySessions = MediatorLiveData<List<DummySession>>()
    private val _navigateToSessionDetail = MutableLiveData<Long>()
    val navigateToSessionDetail: LiveData<Long>
        get() = _navigateToSessionDetail
    private val _saveSessionItem = MutableLiveData<DummySession>()
    val saveSessionItem: LiveData<DummySession>
        get() = _saveSessionItem

    fun getDaySessions(day: String) {
        when (day) {
            "Day 1" -> {
                daySessions.value = generateSessions()
            }
            "Day 2" -> {
                daySessions.value = generateSessions()
            }
            "Day 3" -> {
                daySessions.value = generateSessions()
            }
        }
    }

    private fun generateSessions() = listOf(
        DummySession(
            sessionSpeaker = "Jabez Magomere",
            sessionTitle = "Coroutines In Depth",
            sessionVenue = "Twiga Foods",
            sessionDescription = "A beginner guide to asynchronous programming",
            sessionStartTime = "9:00 AM",
            sessionEndTime = "9:30 AM",
            sessionTimeZone = "AM"
        ),
        DummySession(
            sessionSpeaker = "Jake Wharton",
            sessionTitle = "Retrofit",
            sessionVenue = "ROOM 2",
            sessionDescription = "Let's retrofit",
            sessionStartTime = "9:30 AM",
            sessionEndTime = "10:30 AM",
            sessionTimeZone = "AM"
        ),
        DummySession(
            sessionSpeaker = "Chris Banes",
            sessionTitle = "Kotlin Flows",
            sessionVenue = "ROOM 3",
            sessionDescription = "Flowing in Kotlin",
            sessionStartTime = "11:00 AM",
            sessionEndTime = "11:30 AM",
            sessionTimeZone = "AM"
        ),
        DummySession(
            sessionSpeaker = "Juma Allan",
            sessionTitle = "Android Modularization",
            sessionVenue = "ROOM 2",
            sessionDescription = "Modularization:The Branch Story",
            sessionStartTime = "12:00 AM",
            sessionEndTime = "12:30 AM",
            sessionTimeZone = "AM"
        ),
        DummySession(
            sessionSpeaker = "Android Maestro",
            sessionTitle = "Invalidate caches/ restart",
            sessionVenue = "Room 4",
            sessionDescription = "How to be a rockstar developer",
            sessionStartTime = "2:00 AM",
            sessionEndTime = "2:30 AM",
            sessionTimeZone = "AM"
        )
    )

    fun onSessionItemClicked(sessionId: Long) {
        _navigateToSessionDetail.value = sessionId
    }

    fun onSessionDetailNavigated() {
        _navigateToSessionDetail.value = 0L
    }

    fun onSaveSessionItemClicked(session: DummySession) {
        _saveSessionItem.value = session
    }

    fun onSessionItemSaved() {
        _saveSessionItem.value = DummySession(
            0L, "", "", "",
            "", "", "", "", false
        )
    }
}