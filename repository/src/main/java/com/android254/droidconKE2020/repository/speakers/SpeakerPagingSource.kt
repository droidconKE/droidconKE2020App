package com.android254.droidconKE2020.repository.speakers

import androidx.paging.PagingSource
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.mappers.toSpeakerUIModel
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_NUMBER = 1

class SpeakerPagingSource(private val apiService: ApiService) :
    PagingSource<Int, SpeakerUIModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SpeakerUIModel> {
        val position = params.key ?: PAGE_NUMBER
        return try {
            val response = apiService.speakers.getSpeakers(params.loadSize)
            val speakers = response.speakers.map { speaker ->
                speaker.toSpeakerUIModel()
            }
            LoadResult.Page(
                data = speakers,
                prevKey = if (position == PAGE_NUMBER) null else position - 1,
                nextKey = if (response.speakers.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}