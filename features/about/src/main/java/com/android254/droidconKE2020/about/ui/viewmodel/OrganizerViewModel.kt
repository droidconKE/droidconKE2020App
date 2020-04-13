package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.about.ui.views.Organizer

/**
 * 11/04/20
 */
class OrganizerViewModel: ViewModel() {
    private val _organizerTitle: MutableLiveData<String> = MutableLiveData()
    fun getOrganizerTitle(): MutableLiveData<String> =
        _organizerTitle
    private val _organizerName: MutableLiveData<String> = MutableLiveData()
    fun getOrganizerName(): MutableLiveData<String> =
        _organizerName
    private val _organizerImage: MutableLiveData<Int> = MutableLiveData()
    fun getOrganizerImage(): MutableLiveData<Int> =
        _organizerImage

    fun bind(organizer: Organizer) {
        _organizerTitle.value = organizer.title
        _organizerName.value = organizer.name
        _organizerImage.value = organizer.imageUrl
    }
}