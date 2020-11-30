package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.Sessions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionsEndpoints {

    @GET("events/droidconke2020-645/schedule")
    suspend fun fetchSchedule(
        @Query("grouped") isGrouped : Boolean = true
    ) : Response<Sessions>
}