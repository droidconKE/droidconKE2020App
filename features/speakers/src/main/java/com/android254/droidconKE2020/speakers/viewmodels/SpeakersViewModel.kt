package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.models.SocialMedia
import com.android254.droidconKE2020.speakers.models.Speaker
import com.github.javafaker.Faker

class SpeakersViewModel(private val speakerRepository: FakeSpeakerRepository) : ViewModel() {

    /**
     * Search stuff
     */
    private val _searchPhrase = MutableLiveData<String>()
    val searchPhrase get() = _searchPhrase
    fun setSearchPhrase(searchPhrase: String) {
        _searchPhrase.postValue(searchPhrase)
    }

    /**
     * Speaker stuff
     * */
    val speakerList get() = speakerRepository.sessionSpeakers

    fun retrieveSpeakerList() {
        speakerRepository.refreshSpeakers()
    }

    /**
     * Star stuff
     * */
    fun adjustStars(speakerId: Int) {
        // ToDo
    }
}

class FakeSpeakerRepository {
    private val db = mutableListOf<Speaker>()
    val keynoteSpeaker = MutableLiveData<Speaker>()
    val sessionSpeakers = MutableLiveData<List<Speaker>>()

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
