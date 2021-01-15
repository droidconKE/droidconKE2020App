package com.android254.droidconKE2020.network.endpoints

import com.android254.droidconKE2020.network.responses.Message
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface SessionFeedbackEndpoints {

    @FormUrlEncoded
    @POST("events/droidconke2021-957/feedback/sessions/{session_slug}")
    suspend fun submitSessionFeedback(
        @Path("session_slug") sessionSlug: String,
        @Field("feedback") feedback: String,
        @Field("rating") rating: Int
    ): Response<Message>
}