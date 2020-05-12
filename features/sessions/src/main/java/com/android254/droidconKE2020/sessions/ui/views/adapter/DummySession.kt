package com.android254.droidconKE2020.sessions.ui.views.adapter

import kotlin.random.Random

data class DummySession(
    val sessionId: Long = Random.nextLong(),
    val sessionTitle: String?,
    val sessionDescription: String?,
    val sessionStartTime: String?,
    val sessionEndTime: String?,
    val sessionSpeaker: String?,
    val sessionVenue: String?,
    val sessionTimeZone: String?,
    var isSessionSaved: Boolean = false
)