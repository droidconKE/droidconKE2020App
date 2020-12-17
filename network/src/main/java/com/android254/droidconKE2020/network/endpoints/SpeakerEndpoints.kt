package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Speakers
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeakerEndpoints {

    @GET("events/${ApiConstants.DROIDCON_EVENT}/speakers")
    suspend fun getSpeakers(@Query("per_page") perPage: Int = 15): Speakers
}