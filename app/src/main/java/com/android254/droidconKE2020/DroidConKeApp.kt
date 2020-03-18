package com.android254.droidconKE2020

import android.app.Application
import com.android254.droidconKE2020.data.di.databaseModule
import com.android254.droidconKE2020.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * 16/03/20
 * @author bernard
 */
class DroidConKeApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@DroidConKeApp)
            modules(listOf(databaseModule, networkModule))
        }
    }
}