package com.android254.droidconKE2020.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.*
import kotlin.random.Random

class HomeViewModel(
    private val promotionRepository: FakePromotionRepository,
    private val sessionRepository: FakeSessionRepository,
    private val speakerRepository: FakeSpeakerRepository,
    private val sponsorRepository: FakeSponsorRepository,
    private val organizerRepository: FakeOrganizerRepository
) : ViewModel() {

    /**
     * Promotion stuff
     * */
    val activePromo get() = promotionRepository.activePromo

    fun checkForNewPromo() {
        promotionRepository.checkForAvailablePromotions()
    }

    /**
     * CFP stuff
     * */
    val callForSpeakerUrl: String get() = "https://sessionize.com/droidconke"


    /**
     * Session stuff
     * */
    val sessionList get() = sessionRepository.sessions
    fun retrieveSessionList() {
        sessionRepository.refreshSessions()
    }

    /**
     * Speaker stuff
     * */
    private val _isShowingAllSpeakers = MutableLiveData<Boolean>()
    val isShowingAllSpeakers get() = _isShowingAllSpeakers
    fun setIsShowingAllSpeakers(isShowingAll: Boolean) {
        _isShowingAllSpeakers.value = isShowingAll
    }

    val keynoteSpeaker get() = speakerRepository.keynoteSpeaker
    val speakerList get() = speakerRepository.sessionSpeakers
    fun retrieveSpeakerList() {
        speakerRepository.refreshSpeakers()
    }


    /**
     * Sponsor stuff
     * */
    val becomeSponsorSubject: String get() = "Sponsor DroidConKe20"
    val becomeSponsorEmails: Array<String>
        get() = arrayOf(
            "frank@droidcon.co.ke",
            "another@droidcon.co.ke"
        )

    val sponsors get() = sponsorRepository.sponsors
    fun retrieveSponsors() {
        sponsorRepository.refreshSponsors()
    }

    /**
     * Organizers stuff
     * */
    val organizerList get() = organizerRepository.organizers
    fun retrieveOrganizerList() {
        organizerRepository.refreshOrganizers()
    }

}


class FakePromotionRepository {
    val activePromo = MutableLiveData<Promotion>()

    fun checkForAvailablePromotions() {
        val dummyImgResource = "${R.drawable.black_friday_twitter}"
        val dummyWebUrl = "https://mookh.com/event/droidconke2020/"
        activePromo.postValue(Promotion(dummyImgResource, dummyWebUrl, 0))
    }
}

class FakeSessionRepository {
    private val db = mutableListOf<Session>()
    val sessions = MutableLiveData<List<Session>>()

    fun refreshSessions() {
        db.clear()

        for (i in 0 until 10) {
            db.add(
                Session(
                    id = i.toLong(),
                    description = "Some short description",
                    room = "Room $i",
                    time = "10:5$i",
                    imageUrl = "${R.drawable.dummy_session_image}"
                )
            )
        }
        sessions.postValue(db)
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

class FakeSponsorRepository {
    private val db = mutableListOf<Sponsor>()

    val sponsors = MutableLiveData<List<Sponsor>>()

    fun refreshSponsors() {
        db.clear()
        db.addAll(
            listOf(
                Sponsor(
                    1,
                    "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
                    "https://www.google.com", true
                ), Sponsor(
                    2,
                    "https://hire.andela.com/hs-fs/hubfs/Images_Feb_Folder/Andela-logo-landscape-blue-400px.png?width=3163&height=923&name=Andela-logo-landscape-blue-400px.png",
                    "https://andela.com"
                ), Sponsor(
                    3,
                    "https://avatars0.githubusercontent.com/u/16653668?s=280&v=4",
                    "https://www.hover.com"
                ), Sponsor(
                    4,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/JetBrains_Logo_2016.svg/1200px-JetBrains_Logo_2016.svg.png",
                    "https://www.jetbrains.com"
                )
            )
        )
        sponsors.postValue(db)
    }
}

class FakeOrganizerRepository {
    private val db = mutableListOf<Organizer>()

    val organizers = MutableLiveData<List<Organizer>>()

    fun refreshOrganizers() {
        db.clear()
        for (i in 0 until 10) {
            db.add(Organizer(imageUrl = ""))
        }
        organizers.postValue(db)
    }
}