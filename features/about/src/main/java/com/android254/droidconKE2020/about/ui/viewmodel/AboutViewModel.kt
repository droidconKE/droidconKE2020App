package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.ui.views.Organizer

/**
 * 29/03/20
 */
class AboutViewModel : ViewModel() {
    private val _organizer: MediatorLiveData<List<Organizer>> = MediatorLiveData()

    val organizer: MediatorLiveData<List<Organizer>>
        get() = _organizer

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

        _organizer.value = list
    }
}
