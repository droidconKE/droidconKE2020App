package com.android254.droidconKE2020.sessions.ui.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession

class BookmarkedSessionsViewModel: ViewModel() {

    private val _bookmarkedSessions = MutableLiveData<List<DummySession>>()
    val bookmarkedSessions: LiveData<List<DummySession>>
        get() = _bookmarkedSessions

    private val _isNavigateBack = MutableLiveData<Boolean>()
    val isNavigateBack: LiveData<Boolean>
        get() = _isNavigateBack

    fun getBookMarkedSessions(){
        _bookmarkedSessions.value = generateBookmarkedSessions()
    }

    fun onNavigateBack() {
        _isNavigateBack.value = true
    }

    fun onNavigatedBack() {
        _isNavigateBack.value = null
    }

    private fun generateBookmarkedSessions() = listOf(
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
            sessionSpeaker = "Android Maestro",
            sessionTitle = "Invalidate caches/ restart",
            sessionVenue = "Room 4",
            sessionDescription = "How to be a rockstar developer",
            sessionStartTime = "2:00 AM",
            sessionEndTime = "2:30 AM",
            sessionTimeZone = "AM",
            isSessionSaved = true
        ),
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