package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Sponsors
import retrofit2.Response
import retrofit2.http.GET

interface EventEndpoints {

    @GET("events/${ApiConstants.DROIDCON_EVENT}/sponsors")
    suspend fun getSponsors(): Response<Sponsors>
}