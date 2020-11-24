package com.android254.droidconKE2020.repository.feed

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.network.ApiService
import com.android254.droidconKE2020.network.responses.FeedItem
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    suspend fun getFeed() : Flow<PagingData<FeedUIModel>>
}

class FeedRepositoryImpl(private val apiService: ApiService) : FeedRepository {
    override suspend fun getFeed(): Flow<PagingData<FeedUIModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {FeedPagingSource(apiService = apiService)}
        ).flow
    }

}