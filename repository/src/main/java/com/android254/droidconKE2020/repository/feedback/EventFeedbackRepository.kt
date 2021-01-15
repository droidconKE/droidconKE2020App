package com.android254.droidconKE2020.repository.feedback

import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.Data

interface EventFeedbackRepository {
    suspend fun sendEventFeedback(feedback: String, rating: Int): Data<String>
}

class EventFeedbackRepositoryImpl(private val apiService: ApiService) : EventFeedbackRepository {
    override suspend fun sendEventFeedback(feedback: String, rating: Int): Data<String> {
        return try {
            val response = apiService.eventFeedback.sendEventFeedback(feedback, rating)
            when {
                response.isSuccessful -> Data.Success(response.body()!!.message)
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}