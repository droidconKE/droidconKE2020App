package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.Sponsors
import retrofit2.http.GET

interface EventEndpoints {

    @GET("events/${Constants.DROIDCON_EVENT}/sponsors")
    suspend fun getSponsors(): Sponsors
}