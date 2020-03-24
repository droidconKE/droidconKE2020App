package com.android254.droidconKE2020.core

import android.content.Context
import android.content.SharedPreferences
import com.android254.droidconKE2020.core.di.Constants.SHARED_PREF_FILE_NAME

class PreferencesImpl(context: Context): Preferences {

    override val sharedPref: SharedPreferences = context
        .getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

    private fun editSharedPref(action: (s: SharedPreferences.Editor) -> Unit) {
        with (sharedPref.edit()) {
            action(this)
            apply()
        }
    }

    override fun getShowSplashScreen(): Boolean {
        return sharedPref.getBoolean("showSplashScreen", true)
    }

    override fun setShowSplashScreen(showSplashScreen: Boolean) {
        editSharedPref {
            it.putBoolean("showSplashScreen", showSplashScreen)
        }
    }
}