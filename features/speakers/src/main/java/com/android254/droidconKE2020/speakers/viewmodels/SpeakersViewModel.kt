package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.repository.speakers.SpeakerRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class SpeakersViewModel(private val speakerRepository: SpeakerRepository) : ViewModel() {

    val searchTerm = MutableStateFlow("")

    private val _hasSearchTerm = searchTerm.map { it.isNotEmpty() }
    val hasSearchTerm = _hasSearchTerm.asLiveData()

    @OptIn(FlowPreview::class)
    fun getSpeakers(): LiveData<PagingData<SpeakerUIModel>> = speakerRepository.fetchSpeakers()
        .cachedIn(viewModelScope)
        .combine(searchTerm) { speakers, search ->
            if (search.isNotEmpty()) {
                speakers.filter { speaker ->
                    speaker.speakerName.contains(search, true)
                }
            } else {
                speakers
            }
        }
        .asLiveData()
}