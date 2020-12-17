package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Organizers
import retrofit2.Response
import retrofit2.http.GET

interface OrganizersEndpoints {

    @GET("organizers/${ApiConstants.DROIDCON_SLUG}/team")
    suspend fun fetchOrganizers(): Response<Organizers>
}