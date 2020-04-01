package com.android254.droidconKE2020.sessions.ui.views.models

import kotlin.random.Random

data class DummySessionDetail(
    val sessionDuration: String,
    val sessionVenue: String,
    val sessionTargetType: String,
    val sessionTitle: String,
    val sessionDescription: String,
    val sessionSpeaker: String,
    val sessionSpeakerDescription: String,
    val sessionSpeakerJob: String,
    val sessionImageURL: String,
    val sessionSpeakerId: Long = Random.nextLong(),
    var isSaved: Boolean = false
)