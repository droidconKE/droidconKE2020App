package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.Speakers
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeakerEndpoints {

    @GET("events/${Constants.DROIDCON_EVENT}/speakers")
    suspend fun getSpeakers(@Query("per_page") perPage: Int = 15): Speakers
}