package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.Sessions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionsEndpoints {

    @GET("events/${Constants.DROIDCON_EVENT}/schedule")
    suspend fun fetchSchedule(
        @Query("grouped") isGrouped: Boolean = true
    ): Response<Sessions>
}