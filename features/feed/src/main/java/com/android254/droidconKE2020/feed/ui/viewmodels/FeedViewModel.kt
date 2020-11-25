package com.android254.droidconKE2020.feed.ui.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.repository.feed.FeedRepository

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {

    fun getFeeds(): LiveData<PagingData<FeedUIModel>> {
        return feedRepository.getFeed().asLiveData()
    }
}