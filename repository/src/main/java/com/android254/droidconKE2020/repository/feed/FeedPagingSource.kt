package com.android254.droidconKE2020.repository.feed

import androidx.paging.PagingSource
import com.android254.droidconKE2020.network.ApiService
import com.android254.droidconKE2020.network.responses.FeedItem
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_NUMBER = 1

class FeedPagingSource(private val apiService : ApiService) :PagingSource<Int,FeedItem>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FeedItem> {
        val position = params.key ?: PAGE_NUMBER
        return try {
            val response = apiService.feed.fetchFeeds(params.loadSize)
            LoadResult.Page(
                data = response.feedItems,
                prevKey = if (position == PAGE_NUMBER) null else position - 1,
                nextKey = response.meta.paginator.nextPage
            )

        }catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}