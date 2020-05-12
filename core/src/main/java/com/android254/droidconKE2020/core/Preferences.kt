package com.android254.droidconKE2020.core

import android.content.SharedPreferences

interface Preferences {
    val sharedPref: SharedPreferences

    fun getShowSplashScreen(): Boolean
    fun setShowSplashScreen(showSplashScreen: Boolean)

    fun getUserTheme(): Int
    fun setUserTheme(theme: Int)

    fun isSignedIn(): Boolean
    fun setSignedIn(value: Boolean)
}