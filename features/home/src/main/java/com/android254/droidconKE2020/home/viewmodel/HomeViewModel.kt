package com.android254.droidconKE2020.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Organizer
import com.android254.droidconKE2020.home.domain.Promotion
import com.android254.droidconKE2020.home.domain.Session
import com.android254.droidconKE2020.home.domain.Sponsor
import com.android254.droidconKE2020.home.repositories.FakeSpeakerRepository

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
                ), Sponsor(
                    5,
                    "https://miro.medium.com/max/2370/1*a1Sy9bAOy6vZzILhvhSYjA.png",
                    "https://www.facebook.com"
                ), Sponsor(
                    6,
                    "https://img.favpng.com/12/24/19/pied-piper-of-hamelin-computer-icons-clip-art-png-favpng-HCANn6weBGtG9BLp5BJkLqwYx.jpg",
                    "https://www.jetbrains.com"
                ), Sponsor(
                    7,
                    "https://vignette.wikia.nocookie.net/silicon-valley/images/f/f0/Hooli.png/revision/latest/scale-to-width-down/340?cb=20160811201728",
                    "https://www.jetbrains.com"
                ), Sponsor(
                    8,
                    "https://res-5.cloudinary.com/crunchbase-production/image/upload/c_lpad,h_256,w_256,f_auto,q_auto:eco/v1507291476/i6rr6zn0myh1bg1y6jan.jpg",
                    "https://www.jetbrains.com"
                ), Sponsor(
                    9,
                    "https://media-exp1.licdn.com/dms/image/C560BAQFi15PqkUndWg/company-logo_200_200/0?e=2159024400&v=beta&t=1snlZD0vqCn6hgvJ_FsYxTAFCddq22hbdxWujzCIvaY",
                    "https://www.jetbrains.com", true
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