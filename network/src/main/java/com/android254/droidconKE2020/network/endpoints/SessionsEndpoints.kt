package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.responses.AllSessions
import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Message
import com.android254.droidconKE2020.network.responses.Sessions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SessionsEndpoints {

    @GET("events/${ApiConstants.DROIDCON_EVENT}/schedule")
    suspend fun fetchSchedule(
        @Query("grouped") isGrouped: Boolean = true
    ): Response<Sessions>

    @POST("events/${ApiConstants.DROIDCON_EVENT}/bookmark_schedule/{sessionId}")
    suspend fun changeBookmarkStatus(
        @Path("sessionId") sessionId: Int
    ): Response<Message>

    @GET("events/${ApiConstants.DROIDCON_EVENT}/schedule")
    suspend fun fetchSessions(): Response<AllSessions>
}