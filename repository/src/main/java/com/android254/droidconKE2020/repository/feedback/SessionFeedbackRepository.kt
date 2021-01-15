package com.android254.droidconKE2020.repository.feedback

import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.Data

interface SessionFeedbackRepository {
    suspend fun submitSessionFeedback(sessionSlug: String, feedback: String, rating: Int): Data<String>
}

class SessionFeedbackRepositoryImpl(private val apiService: ApiService) : SessionFeedbackRepository {
    override suspend fun submitSessionFeedback(
        sessionSlug: String,
        feedback: String,
        rating: Int
    ): Data<String> {
        return try {
            val response = apiService.sessionFeedback.submitSessionFeedback(sessionSlug, feedback, rating)
            when {
                response.isSuccessful -> Data.Success(response.body()!!.message)
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}