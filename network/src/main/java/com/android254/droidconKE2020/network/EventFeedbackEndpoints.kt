package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.Message
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface EventFeedbackEndpoints {
    @POST("events/droidconke2021-957/feedback")
    fun sendEventFeedback(
        @Field("feedback") feedback : String,
        @Field("") rating : String
    ) : Response<Message>
}