package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.about.ui.views.Organizer

/**
 * 29/03/20
 */
class AboutViewModel : ViewModel() {
    private val _organizers: MutableLiveData<List<Organizer>> = MutableLiveData()

    val organizers: MutableLiveData<List<Organizer>>
        get() = _organizers

    fun createDummyData() {
        // TODO Remove use of dummy data
        val list = mutableListOf<Organizer>()
        for (i in 0 until 12) {
            list.add(
                Organizer(
                    name = "Frank Tamre",
                    title = "Developer"
                )
            )
        }

        _organizers.value = list
    }
}
