package com.android254.droidconKE2020.sessions.ui.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
import com.android254.droidconKE2020.sessions.ui.views.models.DaySession

class SessionsViewModel : ViewModel() {
    private val _daySessions = MutableLiveData<List<DaySession>>()
    val daySessions: LiveData<List<DaySession>>
        get() = _daySessions

    private val _bookmarkedSessions = MutableLiveData<List<DummySession>>()
    val bookmarkedSessions: LiveData<List<DummySession>>
        get() = _bookmarkedSessions

    private val _sessionId = MutableLiveData<Long>()
    val sessionId: LiveData<Long>
        get() = _sessionId

    private val _removedSessionItem = MutableLiveData<DummySession>()
    val removedSessionItem: LiveData<DummySession>
        get() = _removedSessionItem

    fun getDaySessions() {
        val daySession1 = DaySession("06", "Day 1")
        val daySession2 = DaySession("07", "Day 2")
        val daySession3 = DaySession("08", "Day 3")
        val daySessionsList = listOf(daySession1, daySession2, daySession3)
        _daySessions.value = daySessionsList
    }

    fun getBookMarkedSessions(){
        _bookmarkedSessions.value = generateAllSessions().filter { it.isSessionSaved }
    }

    fun onSessionItemClicked(sessionId: Long) {
        _sessionId.value = sessionId
    }

    fun onRemoveSavedSession(session: DummySession){
        _removedSessionItem.value = session
    }

    private fun generateAllSessions() = listOf(
        DummySession(
            sessionSpeaker = "Jabez Magomere",
            sessionTitle = "Coroutines In Depth",
            sessionVenue = "Twiga Foods",
            sessionDescription = "A beginner guide to asynchronous programming",
            sessionStartTime = "9:00 AM",
            sessionEndTime = "9:30 AM",
            sessionTimeZone = "AM",
            isSessionSaved = true
        ),
        DummySession(
            sessionSpeaker = "Jake Wharton",
            sessionTitle = "Retrofit",
            sessionVenue = "ROOM 2",
            sessionDescription = "Let's retrofit",
            sessionStartTime = "9:30 AM",
            sessionEndTime = "10:30 AM",
            sessionTimeZone = "AM",
            isSessionSaved = true

        ),
        DummySession(
            sessionSpeaker = "Chris Banes",
            sessionTitle = "Kotlin Flows",
            sessionVenue = "ROOM 3",
            sessionDescription = "Flowing in Kotlin",
            sessionStartTime = "11:00 AM",
            sessionEndTime = "11:30 AM",
            sessionTimeZone = "AM",
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
            sessionTimeZone = "AM",
            isSessionSaved = true
        )
    )


}