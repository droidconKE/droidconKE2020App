package com.android254.droidconKE2020.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Promotion
import com.android254.droidconKE2020.home.domain.Speaker
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    private val _ongoingPromo = MutableLiveData<Promotion>() // ToDo: Fetch from repository
    val ongoingPromo get() = _ongoingPromo

    fun checkForNewPromo() {
        // ToDo: Refresh promos and store in repository
        // ToDo: Remove expired promos from cache (room) in repository by comparing expiryDateInEpoch
        val dummyImgResource = "${R.drawable.black_friday_twitter}"
        val dummyWebUrl = "https://mookh.com/event/droidconke2020/"
        _ongoingPromo.postValue(Promotion(dummyImgResource, dummyWebUrl, 0))
    }

    private val _keynoteSpeaker = MutableLiveData<Speaker>() // ToDo: Fetch from repository
    val keynoteSpeaker get() = _keynoteSpeaker

    fun retrieveKeynoteSpeaker() {
        // ToDo: Refresh keynote speaker form api and store in repository
        val id = Random.nextInt()
        val name = "Greg Speaker"
        val imageUrl = "https://loremflickr.com/320/320/dog"
        _keynoteSpeaker.postValue(Speaker(id, name, imageUrl))
    }

}
