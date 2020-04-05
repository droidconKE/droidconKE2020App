package com.android254.droidconKE2020.home.utlities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.navigation.findNavController
import com.android254.droidconKE2020.home.ui.views.HomeFragmentDirections

object CommonTasks {

    fun launchBrowser(webUrl: String, context: Context) {
        // ToDo: replace wit in-app browser
        context.startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(webUrl)))
    }

    fun onSpeakerClicked(speakerId: Int, view: View) {
        val speakerDetailsAction =
            HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment()
        view.findNavController().navigate(speakerDetailsAction)
    }
}