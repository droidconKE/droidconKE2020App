package com.android254.droidconKE2020.repository.sessions

import com.android254.droidconKE2020.core.models.Sessions
import com.android254.droidconKE2020.network.ApiService
import com.android254.droidconKE2020.repository.Data

interface SessionRepository {

    suspend fun fetchSessionsSchedule() : Data<Sessions>
}

class SessionRepositoryImpl(private val apiService: ApiService) : SessionRepository{
    override suspend fun fetchSessionsSchedule(): Data<Sessions> {
        val response = apiService.sessionSchedule.fetchSchedule()
        return try {
            when{
                response.isSuccessful -> Data.Success(response.body()!!)
                else -> Data.Error(response.message())
            }

        } catch (exception : Exception) {
            Data.Error(exception.message)
        }
    }

}