package com.android254.droidconKE2020.feed.ui.viewmodels

import android.content.Context
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.feed.R
import com.android254.droidconKE2020.feed.models.Feed
import com.android254.droidconKE2020.repository.feed.FeedRepository
import kotlinx.coroutines.launch

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {
    private var _feeds = MutableLiveData<PagingData<FeedUIModel>>()
    val feeds get() = _feeds

    fun getFeeds() {
        viewModelScope.launch {
           _feeds.postValue(feedRepository.getFeed().asLiveData().value)
        }
    }
}