package com.android254.droidconKE2020.home.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.models.OrganizerUIModel
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.core.models.SponsorUIModel
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Promotion
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.EventRepository
import com.android254.droidconKE2020.repository.organizers.OrganizersRepository
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.repository.speakers.SpeakerRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class HomeViewModel(
    private val promotionRepository: FakePromotionRepository,
    private val sessionRepository: SessionRepository,
    private val speakerRepository: SpeakerRepository,
    private val eventRepository: EventRepository,
    private val organizerRepository: OrganizersRepository
) : ViewModel() {
    private var _sessions = MutableLiveData<List<SessionUIModel>>()
    val sessions: LiveData<List<SessionUIModel>> get() = _sessions
    val showToast = SingleLiveEvent<String>()
    private var _sponsors = MutableLiveData<List<SponsorUIModel>>()
    val sponsors: LiveData<List<SponsorUIModel>> get() = _sponsors
    private var _organizers = MutableLiveData<List<OrganizerUIModel>>()
    val organizers: LiveData<List<OrganizerUIModel>> get() = _organizers
    private val _speakers = MutableLiveData<List<SpeakerUIModel>>()
    val speakers: LiveData<List<SpeakerUIModel>> get() = _speakers
    private val _keynoteSpeaker = MutableLiveData<SpeakerUIModel>()
    val keynoteSpeaker: LiveData<SpeakerUIModel> get() = _keynoteSpeaker

    fun loadData() = viewModelScope.launch {
        val deferredList = listOf(
            async { fetchAllSessions() },
            async { fetchSponsors() },
            async { fetchSpeakers() },
            async { fetchOrganizers() }
        )
        deferredList.awaitAll()
    }

    suspend fun fetchAllSessions() {
        when (val value = sessionRepository.fetchAllSessions()) {
            is Data.Success -> {
                _sessions.value = value.data
                value.data.forEach { sessionUIModel ->
                    if (sessionUIModel.isKeynote) {
                        _keynoteSpeaker.value = sessionUIModel.sessionSpeakers.first()
                    }
                }
            }
            is Data.Error -> showToast.value = value.exception.toString()
        }
    }

    suspend fun fetchSponsors() {
        when (val value = eventRepository.fetchSponsors()) {
            is Data.Success -> _sponsors.value = value.data
            is Data.Error -> showToast.value = value.exception.toString()
        }
    }

    suspend fun fetchOrganizers() {
        when (val value = organizerRepository.fetchOrganizers()) {
            is Data.Success -> _organizers.value = value.data
            is Data.Error -> showToast.value = value.exception.toString()
        }
    }

    suspend fun fetchSpeakers() {
        when (val value = speakerRepository.fetchSomeSpeakers()) {
            is Data.Success -> {
                _speakers.value = value.data
            }
            is Data.Error -> showToast.value = value.exception.toString()
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
}

class FakePromotionRepository {
    val activePromo = MutableLiveData<Promotion>()

    fun checkForAvailablePromotions() {
        val dummyImgResource = "${R.drawable.black_friday_twitter}"
        val dummyWebUrl = "https://mookh.com/event/droidconke2020/"
        activePromo.postValue(Promotion(dummyImgResource, dummyWebUrl, 0))
    }
}