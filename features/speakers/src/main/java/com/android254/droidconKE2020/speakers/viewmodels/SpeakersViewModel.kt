package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speakers.models.SocialMedia
import com.android254.droidconKE2020.speakers.models.Speaker
import com.github.javafaker.Faker

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

        val faker = Faker()

        for (i in 0 until 47) {
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
                    isKeynoteSpeaker = i == 0
                )
            )
        }

        keynoteSpeaker.postValue(db.removeAt(0))
        sessionSpeakers.postValue(db)
    }
}
