package com.android254.droidconKE2020.feed.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.repository.feed.FeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {
    private var _feeds = MutableLiveData<PagingData<FeedUIModel>>()
    val feeds get() = _feeds

    fun getFeeds() : Flow<PagingData<FeedUIModel>> {
        return feedRepository.getFeed()
    }
}