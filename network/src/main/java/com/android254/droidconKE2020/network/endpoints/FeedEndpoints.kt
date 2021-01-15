package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Feed
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedEndpoints {

    @GET("events/${ApiConstants.DROIDCON_EVENT}/feeds")
    suspend fun fetchFeeds(
        @Query("per_page") pageItems: Int = 10
    ): Feed
}