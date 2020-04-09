package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.models.Speaker
import kotlin.random.Random

class SpeakersViewModel(private val speakerRepository: FakeSpeakerRepository) : ViewModel() {

    /**
     * Speaker stuff
     * */
    val speakerList get() = speakerRepository.sessionSpeakers
    fun retrieveSpeakerList() {
        speakerRepository.refreshSpeakers()
    }

}

class FakeSpeakerRepository {
    private val db = mutableListOf<Speaker>()
    val keynoteSpeaker = MutableLiveData<Speaker>()
    val sessionSpeakers = MutableLiveData<List<Speaker>>()

    fun refreshSpeakers() {
        db.clear()

        for (i in 0 until 10) {
            db.add(
                Speaker(
                    id = Random.nextInt(),
                    name = "Person $i",
                    imageUrl = "https://loremflickr.com/320/320/dog",
                    isKeynoteSpeaker = i == 0
                )
            )
        }

        keynoteSpeaker.postValue(db.removeAt(0))
        sessionSpeakers.postValue(db)
    }
}
