package com.android254.droidconKE2020.repository.speakers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.mappers.toSpeakerUIModel
import kotlinx.coroutines.flow.Flow

interface SpeakerRepository {

    fun fetchSpeakers(): Flow<PagingData<SpeakerUIModel>>

    suspend fun fetchSomeSpeakers(): Data<List<SpeakerUIModel>>
}

class SpeakerRepositoryImpl(private val apiService: ApiService) : SpeakerRepository {

    override fun fetchSpeakers(): Flow<PagingData<SpeakerUIModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SpeakerPagingSource(apiService = apiService) }
        ).flow
    }

    override suspend fun fetchSomeSpeakers(): Data<List<SpeakerUIModel>> {
        return try {
            val response = apiService.speakers.getSpeakers(10)
            Data.Success(response.speakers.map { speaker -> speaker.toSpeakerUIModel() })
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}