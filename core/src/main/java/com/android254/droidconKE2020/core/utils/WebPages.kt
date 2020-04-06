package com.android254.droidconKE2020.core.utils;

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

class WebPages(private val context: Context) {

    fun launchInAppBrowser(webUrl: String, toolbarColorId: Int) {
        val builder = CustomTabsIntent.Builder()

        builder.setStartAnimations(context, android.R.anim.fade_out, android.R.anim.fade_in)
        builder.setExitAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)

        builder.setToolbarColor(ContextCompat.getColor(context, toolbarColorId))
        builder.setShowTitle(true)

        // Check if chrome is installed
        val providerName = CustomTabsClient.getPackageName(context, null)
        if (providerName == null) launchBrowserIntent(webUrl) else {
            val intent = builder.build()
            intent.intent.setPackage(providerName)
            intent.launchUrl(context, Uri.parse(webUrl))
        }
    }

    private fun launchBrowserIntent(webUrl: String) {
        runCatching {
            context.startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(webUrl)))
        }.onFailure {
            val msg = "Install a browser to view this content"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}
