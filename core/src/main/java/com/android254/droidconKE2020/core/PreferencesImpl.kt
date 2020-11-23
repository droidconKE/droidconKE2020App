package com.android254.droidconKE2020.core

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import com.android254.droidconKE2020.core.di.Constants.SHARED_PREF_FILE_NAME

class PreferencesImpl(context: Context) : Preferences {

    override val sharedPref: SharedPreferences = context
        .getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

    private fun editSharedPref(action: (s: SharedPreferences.Editor) -> Unit) {
        with(sharedPref.edit()) {
            action(this)
            apply()
        }
    }

    override fun getShowSplashScreen(): Boolean = sharedPref.getBoolean("showSplashScreen", true)

    override fun setShowSplashScreen(showSplashScreen: Boolean) {
        editSharedPref {
            it.putBoolean("showSplashScreen", showSplashScreen)
        }
    }

    override fun getUserTheme(): Int {
        // Set follow system dark theme on devices higher than Pie and battery on others
        val autoDark = runCatching { AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM }
            .getOrElse { AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY }

        return sharedPref.getInt("theme", autoDark)
    }

    override fun setUserTheme(theme: Int) {
        editSharedPref {
            it.putInt("theme", theme)
        }
    }

    override fun isSignedIn(): Boolean = sharedPref.getBoolean("signedIn", false)

    override fun setSignedIn(value: Boolean) {
        editSharedPref {
            it.putBoolean("signedIn", value)
        }
    }

    override fun getAccessToken(): String = sharedPref.getString("accessToken", "") ?: ""

    override fun setAccessToken(value: String) {
        editSharedPref {
            it.putString("accessToken", value)
        }
    }
}