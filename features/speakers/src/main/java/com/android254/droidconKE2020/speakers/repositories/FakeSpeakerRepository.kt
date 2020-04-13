package com.android254.droidconKE2020.speakers.repositories

import androidx.lifecycle.MutableLiveData
import com.android254.droidconKE2020.speakers.models.SocialMedia
import com.android254.droidconKE2020.speakers.models.Speaker
import com.github.javafaker.Faker

class FakeSpeakerRepository {
    private val db = mutableListOf<Speaker>()
    val keynoteSpeaker = MutableLiveData<Speaker>()
    val sessionSpeakers = MutableLiveData<List<Speaker>>()

    fun retrieveSpeaker(speakerId: Int): Speaker? {
        var speaker: Speaker? = null

        val db = db
        keynoteSpeaker.value?.let { db.add(it) }

        db.forEach {
            if (it.id == speakerId) {
                speaker = it
                return@forEach
            }
        }

        return speaker
    }

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
                    bio = faker.backToTheFuture().quote() + " " +
                            faker.gameOfThrones().quote() + " " +
                            faker.harryPotter().quote() + " " +
                            faker.shakespeare().romeoAndJulietQuote(),
                    work = faker.job().title(),
                    company = faker.company().name(),
                    skills = faker.job().keySkills().split(","),
                    imageUrl = faker.avatar().image(),
                    socialMedia = SocialMedia(twitter = faker.name().username()),
                    stars = listOf(),
                    isKeynoteSpeaker = i == 0
                )
            )
        }

        keynoteSpeaker.postValue(db.removeAt(0))
        sessionSpeakers.postValue(db)
    }
}
 
