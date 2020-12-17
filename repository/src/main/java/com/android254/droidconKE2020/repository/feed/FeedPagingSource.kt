package com.android254.droidconKE2020.repository.feed

import androidx.paging.PagingSource
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.mappers.toFeedUIModel
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_NUMBER = 1

class FeedPagingSource(private val apiService: ApiService) : PagingSource<Int, FeedUIModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FeedUIModel> {
        val position = params.key ?: PAGE_NUMBER
        return try {
            val response = apiService.feed.fetchFeeds(params.loadSize)
            val feeds = response.feedItems.map { feedItem ->
                feedItem.toFeedUIModel()
            }
            LoadResult.Page(
                data = feeds,
                prevKey = if (position == PAGE_NUMBER) null else position - 1,
                nextKey = if (response.feedItems.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}