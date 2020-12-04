package com.android254.droidconKE2020.speakers.viewmodels

import androidx.lifecycle.ViewModel
import java.net.URI

class SpeakerDetailsViewModel : ViewModel() {

    fun getHandleFromUrl(profileUrl: String): String {
        val url = URI(profileUrl)
        var handle = url.path
        if (handle.startsWith("/")) {
            handle = handle.substring(1)
        }
        return "@$handle"
    }
}