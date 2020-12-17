package com.android254.droidconKE2020.home.ui.viewmodel

import androidx.lifecycle.*
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.models.SponsorUIModel
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.*
import com.android254.droidconKE2020.home.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.EventRepository
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val promotionRepository: FakePromotionRepository,
    private val sessionRepository: SessionRepository,
    private val speakerRepository: FakeSpeakerRepository,
    private val eventRepository: EventRepository,
    private val organizerRepository: FakeOrganizerRepository
) : ViewModel() {
    private var _sessions = MutableLiveData<List<SessionUIModel>>()
    val sessions get() = _sessions
    val showToast = SingleLiveEvent<String>()
    private var _sponsors = MutableLiveData<List<SponsorUIModel>>()
    val sponsors get() = _sponsors

    fun fetchAllSessions() {
        viewModelScope.launch {
            when (val value = sessionRepository.fetchAllSessions()) {
                is Data.Success -> _sessions.postValue(value.data)
                is Data.Error -> showToast.postValue(value.exception.toString())
            }
        }
    }

    fun fetchSponsors() {
        viewModelScope.launch {
            when (val value = eventRepository.fetchSponsors()) {
                is Data.Success -> _sponsors.postValue(value.data)
                is Data.Error -> showToast.postValue(value.exception.toString())
            }
        }
    }

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
     * Speaker stuff
     * */
    val keynoteSpeaker get() = speakerRepository.keynoteSpeaker
    val speakerList get() = speakerRepository.sessionSpeakers
    fun retrieveSpeakerList() {
        speakerRepository.refreshSpeakers()
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