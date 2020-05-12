package com.android254.droidconKE2020

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.core.di.sharedPreferencesModule
import com.android254.droidconKE2020.data.di.databaseModule
import com.android254.droidconKE2020.network.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DroidConKeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@DroidConKeApp)
            modules(listOf(databaseModule, networkModule, sharedPreferencesModule))
        }

        setSavedTheme()
    }

    fun setSavedTheme() {
        val sharedPrefs: Preferences by inject()
        val savedTheme = sharedPrefs.getUserTheme()
        AppCompatDelegate.setDefaultNightMode(savedTheme)
    }
}