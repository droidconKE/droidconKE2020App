package com.android254.droidconKE2020.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Promotion

class HomeViewModel : ViewModel() {

    private val _ongoingPromo = MutableLiveData<Promotion>() // ToDo: Fetch from repository
    val ongoingPromo get() = _ongoingPromo

    fun checkForNewPromo() {
        // ToDo: Refresh promos and store in repository
        // ToDo: Remove expired promos from cache (room) in repository by comparing expiryDateInEpoch
        val dummyImgResource = R.drawable.black_friday_twitter
        _ongoingPromo.postValue(Promotion("$dummyImgResource", "", 0))
    }

}
