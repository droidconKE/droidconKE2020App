package com.android254.droidconKE2020.home.viewmodel

import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.*
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    /**
     * Promotion stuff
     * */
    private val _ongoingPromo = MutableLiveData<Promotion>() // ToDo: Fetch from repository
    val ongoingPromo get() = _ongoingPromo

    fun checkForNewPromo() {
        // ToDo: Refresh promos and store in repository
        // ToDo: Remove expired promos from cache (room) in repository by comparing expiryDateInEpoch
        val dummyImgResource = "${R.drawable.black_friday_twitter}"
        val dummyWebUrl = "https://mookh.com/event/droidconke2020/"
        _ongoingPromo.postValue(Promotion(dummyImgResource, dummyWebUrl, 0))
    }

    /**
     * CFP stuff
     * */
    val callForSpeakerUrl: String get() = "https://sessionize.com/droidconke"

    /**
     * Keynote speaker stuff
     * */
    private val _keynoteSpeaker = MutableLiveData<Speaker>() // ToDo: Fetch from repository
    val keynoteSpeaker get() = _keynoteSpeaker

    fun retrieveKeynoteSpeaker() {
        // ToDo: Refresh keynote speaker from api and store in repository
        val id = Random.nextInt()
        val name = "Greg Speaker"
        val imageUrl = "https://loremflickr.com/320/320/dog"
        _keynoteSpeaker.postValue(Speaker(id, name, imageUrl))
    }

    /**
     * Sessions stuff
     * */
    private val _sessionList = MutableLiveData<List<Session>>() // ToDo: Fetch from repository
    val sessionList get() = _sessionList
    fun retrieveSessionList() {
        // ToDo: Refresh sessions from api and store in repository

        val list = mutableListOf<Session>()
        for (i in 0 until 10) {
            list.add(
                Session(
                    id = i.toLong(),
                    description = "Some short description",
                    room = "Room $i",
                    time = "10:5$i",
                    imageUrl = "${R.drawable.dummy_session_image}"
                )
            )
        }
        _sessionList.postValue(list)
    }

    /**
     * Speakers stuff
     * */
    private val _isShowingAllSpeakers = MutableLiveData(false)
    val isShowingAllSpeakers get() = _isShowingAllSpeakers
    fun setIsShowingAllSpeakers(isShowingAll: Boolean) {
        _isShowingAllSpeakers.value = isShowingAll
    }

    private val _speakersList = MutableLiveData<List<Speaker>>() // ToDo: Fetch from repository
    val speakerList get() = _speakersList
    fun retrieveSpeakerList() {
        // ToDo: Refresh speakers from api and store in repository

        val list = mutableListOf<Speaker>()
        for (i in 0 until 10) {
            list.add(
                Speaker(
                    id = Random.nextInt(),
                    name = "Person $i",
                    imageUrl = "https://loremflickr.com/320/320/dog"
                )
            )
        }
        _speakersList.postValue(list)
    }

    /**
     * Sponsor stuff
     * */
    val becomeSponsorEmail: Array<String> get() =arrayOf( "frank@droidcon.co.ke")
    val becomeSponsorSubject: String get() = "Sponsor DroidConKe20"

    private val _sponsors = MutableLiveData<MutableList<Sponsor>>()
    val sponsors get() = _sponsors
    fun retrieveSponsors() {
        val list = mutableListOf(
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

        _sponsors.postValue(list)
    }

    /**
     * Organizers stuff
     * */
    private val _organizerList = MutableLiveData<List<Organizer>>() // ToDo: Fetch from repository
    val organizerList get() = _organizerList
    fun retrieveOrganizerList() {
        // ToDo: Refresh sessions from api and store in repository

        val list = mutableListOf<Organizer>()
        for (i in 0 until 10) {
            list.add(
                Organizer(imageUrl = "")
            )
        }
        _organizerList.postValue(list)
    }

}
