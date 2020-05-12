package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.repositories.FakeSpeakerRepository
import java.util.*

class SpeakersViewModel(private val speakerRepository: FakeSpeakerRepository) : ViewModel() {

    /**
     * Search stuff
     */
    private val _searchPhrase = MutableLiveData<String>()
    val searchPhrase get() = _searchPhrase
    fun clearSearch() = _searchPhrase.postValue("")

    /**
     * Speaker stuff
     * */
    val speakerList get() = speakerRepository.sessionSpeakers
    fun retrieveSpeakerList(searchPhrase: String?) {
        if (searchPhrase.isNullOrBlank()) {
            speakerRepository.refreshSpeakers()
        } else {
            speakerRepository.searchSpeakers(searchPhrase.toLowerCase(Locale.ROOT))
        }
    }
}