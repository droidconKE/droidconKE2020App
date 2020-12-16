package com.android254.droidconKE2020.network.api

import com.android254.droidconKE2020.network.endpoints.*
import retrofit2.Retrofit

class ApiService(retrofit: Retrofit) {
    val events = retrofit.create(EventEndpoints::class.java)
    val auth = retrofit.create(AuthEndpoints::class.java)
    val feed = retrofit.create(FeedEndpoints::class.java)
    val eventFeedback = retrofit.create(EventFeedbackEndpoints::class.java)
    val sessionSchedule = retrofit.create(SessionsEndpoints::class.java)
    val sessionFeedback = retrofit.create(SessionFeedbackEndpoints::class.java)
    val speakers = retrofit.create(SpeakerEndpoints::class.java)
    val organizers = retrofit.create(OrganizersEndpoints::class.java)
}