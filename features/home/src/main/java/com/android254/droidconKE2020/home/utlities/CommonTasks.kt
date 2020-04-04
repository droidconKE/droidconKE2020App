package com.android254.droidconKE2020.home.utlities

import android.content.Context
import android.content.Intent
import android.net.Uri

object CommonTasks {

    fun launchBrowser(webUrl: String, context: Context) {
        // ToDo: replace wit in-app browser
        context.startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(webUrl)))
    }

}