package com.android254.droidconKE2020.repository.feed

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.network.api.ApiService
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    fun getFeed(): Flow<PagingData<FeedUIModel>>
}

class FeedRepositoryImpl(private val apiService: ApiService) : FeedRepository {
    override fun getFeed(): Flow<PagingData<FeedUIModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FeedPagingSource(apiService = apiService) }
        ).flow
    }
}