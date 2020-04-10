package com.android254.droidconKE2020.speakers.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.models.SocialMedia
import com.android254.droidconKE2020.speakers.models.Speaker
import com.github.javafaker.Faker
import java.util.*

class SpeakersViewModel(private val speakerRepository: FakeSpeakerRepository) : ViewModel() {

    /**
     * Search stuff
     */
    private val _searchPhrase = MutableLiveData<String>()
    val searchPhrase get() = _searchPhrase
    fun setSearchPhrase(value: String) {
        _searchPhrase.postValue(value)
    }

    /**
     * Speaker stuff
     * */
    val speakerList get() = speakerRepository.sessionSpeakers

    fun retrieveSpeakerList(searchPhrase: String?) {
        if (searchPhrase.isNullOrBlank()) speakerRepository.refreshSpeakers()
        else speakerRepository.searchSpeakers(searchPhrase.toLowerCase(Locale.ROOT))
    }

    /**
     * Star stuff
     * */
    fun adjustStars(speakerId: Int) {
        Log.e("adjustStars", "Added $speakerId")
        // ToDo
    }
}

class FakeSpeakerRepository {
    private val db = mutableListOf<Speaker>()
    val keynoteSpeaker = MutableLiveData<Speaker>()
    val sessionSpeakers = MutableLiveData<List<Speaker>>()

    fun searchSpeakers(searchPhrase: String) {
        val searchedDb = mutableListOf<Speaker>()
        db.forEach { if (it.toString().toLowerCase().contains(searchPhrase)) searchedDb.add(it) }
        sessionSpeakers.postValue(searchedDb)
    }

    fun refreshSpeakers() {
        db.clear()

        val faker = Faker()

        for (i in 0 until 10) {
            db.add(
                Speaker(
                    id = i,
                    name = faker.funnyName().name(),
                    bio = faker.backToTheFuture().quote(),
                    work = faker.job().title(),
                    company = faker.company().name(),
                    skills = faker.job().keySkills().split(","),
                    imageUrl = faker.avatar().image(),
                    socialMedia = SocialMedia(),
                    stars = listOf(),
                    isKeynoteSpeaker = i == 0
                )
            )
        }

        keynoteSpeaker.postValue(db.removeAt(0))
        sessionSpeakers.postValue(db)
    }
}
