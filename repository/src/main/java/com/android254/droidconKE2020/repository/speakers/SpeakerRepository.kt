package com.android254.droidconKE2020.repository.speakers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.network.ApiService
import kotlinx.coroutines.flow.Flow

interface SpeakerRepository {

    suspend fun fetchSpeakers(): Flow<PagingData<SpeakerUIModel>>

}

class SpeakerRepositoryImpl(private val apiService: ApiService) : SpeakerRepository {

    override suspend fun fetchSpeakers(): Flow<PagingData<SpeakerUIModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SpeakerPagingSource(apiService = apiService) }
        ).flow
    }
}