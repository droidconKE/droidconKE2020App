package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.models.Speaker
import com.android254.droidconKE2020.speakers.repositories.FakeSpeakerRepository

class SpeakerDetailsViewModel(private val speakerRepository: FakeSpeakerRepository) : ViewModel() {

    private val _speaker = MutableLiveData<Speaker>()
    val speakerDetails get() = _speaker
    fun fetchSpeakerDetails(speakerId: Int) {
        _speaker.postValue(speakerRepository.retrieveSpeaker(speakerId))
    }

}