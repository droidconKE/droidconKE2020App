package com.android254.droidconKE2020

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.android254.droidconKE2020.core.PreferencesImpl
import com.android254.droidconKE2020.data.di.databaseModule
import com.android254.droidconKE2020.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * 16/03/20
 * @author bernard
 */
class DroidConKeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setSavedTheme()

        startKoin {
            printLogger()
            androidContext(this@DroidConKeApp)
            modules(listOf(databaseModule, networkModule))
        }
    }

    private fun setSavedTheme() {
        val preferencesImpl = PreferencesImpl(this)
        val savedTheme = preferencesImpl.getUserTheme()
        AppCompatDelegate.setDefaultNightMode(savedTheme)
    }
}