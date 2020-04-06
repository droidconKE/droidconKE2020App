package com.android254.droidconKE2020.core.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat.getColor
import com.android254.droidconKE2020.core.R

class WebPages(private val context: Context) {

    fun launchInAppBrowser(webUrl: String) {
        val builder = CustomTabsIntent.Builder()

        builder.setStartAnimations(context, android.R.anim.fade_out, android.R.anim.fade_in)
        builder.setExitAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)

        // FixMe: Color not set correctly after passing context with di and introducing FLAG_ACTIVITY_NEW_TASK intent flags
        builder.setToolbarColor(getColor(context, R.color.browserToolbarColor))
        builder.setShowTitle(true)

        // Check if chrome is installed
        val providerName = CustomTabsClient.getPackageName(context, null)
        if (providerName == null) launchBrowserIntent(webUrl) else {
            val intent = builder.build()
            intent.intent.setPackage(providerName)
            intent.intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.launchUrl(context, Uri.parse(webUrl))
        }
    }

    private fun launchBrowserIntent(webUrl: String) {
        runCatching {
            context.startActivity(
                Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse(webUrl))
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }.onFailure {
            Toast.makeText(context, context.getString(R.string.browserPrompt), Toast.LENGTH_SHORT)
                .show()
        }
    }
}