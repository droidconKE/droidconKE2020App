package com.android254.droidconKE2020.network

import android.content.SharedPreferences
import com.android254.droidconKE2020.core.Preferences
import org.koin.dsl.module

class FakePreferences : Preferences {
    override val sharedPref: SharedPreferences
        get() = TODO("Not yet implemented")

    override fun getShowSplashScreen(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setShowSplashScreen(showSplashScreen: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getUserTheme(): Int {
        TODO("Not yet implemented")
    }

    override fun setUserTheme(theme: Int) {
        TODO("Not yet implemented")
    }

    override fun isSignedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setSignedIn(value: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getAccessToken(): String = "token"

    override fun setAccessToken(value: String) {
        TODO("Not yet implemented")
    }
}

val fakeModule = module {
    single<Preferences> { FakePreferences() }
}