package com.android254.droidconKE2020.repository.sessions

import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.network.responses.Sessions
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.mappers.toSessionUIModel
import retrofit2.Response

interface SessionRepository {

    suspend fun fetchSessionsSchedule(day: String): Data<List<SessionUIModel>>

    suspend fun changeBookmarkStatus(sessionId: Int): Data<String>

    suspend fun fetchAllSessions(): Data<List<SessionUIModel>>

    suspend fun fetchBookmarkedSessions(day: String):Data<List<SessionUIModel>>
}

class SessionRepositoryImpl(private val apiService: ApiService) : SessionRepository {
    override suspend fun fetchSessionsSchedule(day: String): Data<List<SessionUIModel>> {
        return prepareSessionsSchedule(apiService.sessionSchedule.fetchSchedule(), day)
    }

    override suspend fun changeBookmarkStatus(sessionId: Int): Data<String> {
        return try {
            val response = apiService.sessionSchedule.changeBookmarkStatus(sessionId)
            when {
                response.isSuccessful -> Data.Success(response.body()!!.message)
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }

    override suspend fun fetchAllSessions(): Data<List<SessionUIModel>> {
        return try {
            val response = apiService.sessionSchedule.fetchSessions()
            when {
                response.isSuccessful -> Data.Success(
                    response.body()!!.sessions.map { sessionItem ->
                        sessionItem.toSessionUIModel()
                    }
                )
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }

    override suspend fun fetchBookmarkedSessions(day: String): Data<List<SessionUIModel>> {
        return prepareSessionsSchedule(apiService.sessionSchedule.fetchBookMarkedSessions(), day)
    }

   private fun prepareSessionsSchedule(
        response: Response<Sessions>,
        day: String
    ): Data<List<SessionUIModel>> {
        return try {
            when {
                response.isSuccessful -> {
                    val data = response.body()!!
                    when (day) {
                        "Day 1" -> {
                            Data.Success(
                                data.sessionDays.dayOneSessions.map { sessionItem ->
                                    sessionItem.toSessionUIModel()
                                }
                            )
                        }
                        "Day 2" -> {
                            Data.Success(
                                data.sessionDays.dayTwoSessions.map { sessionItem ->
                                    sessionItem.toSessionUIModel()
                                }
                            )
                        }
                        "Day 3" -> {
                            Data.Success(
                                data.sessionDays.dayThreeSessions.map { sessionItem ->
                                    sessionItem.toSessionUIModel()
                                }
                            )
                        }
                        else -> {
                            Data.Success(emptyList())
                        }
                    }
                }
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}