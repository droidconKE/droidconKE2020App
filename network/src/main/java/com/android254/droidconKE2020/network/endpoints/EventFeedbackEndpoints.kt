package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.utils.ApiConstants
import com.android254.droidconKE2020.network.responses.Message
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EventFeedbackEndpoints {

    @FormUrlEncoded
    @POST("events/${ApiConstants.DROIDCON_EVENT}/feedback")
    suspend fun sendEventFeedback(
        @Field("feedback") feedback: String,
        @Field("rating") rating: Int
    ): Response<Message>
}