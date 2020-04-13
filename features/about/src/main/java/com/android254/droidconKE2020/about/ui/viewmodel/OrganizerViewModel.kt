package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.about.ui.views.Organizer

/**
 * 11/04/20
 */
class OrganizerViewModel: ViewModel() {
    val organizerTitle: MutableLiveData<String> = MutableLiveData()
    val organizerName: MutableLiveData<String> = MutableLiveData()
    val organizerImage: MutableLiveData<Int> = MutableLiveData()

    fun bind(organizer: Organizer) {
        organizerTitle.value = organizer.title
        organizerName.value = organizer.name
        organizerImage.value = organizer.imageUrl
    }
}