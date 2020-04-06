package com.android254.droidconKE2020.core.di

import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.core.PreferencesImpl
import com.android254.droidconKE2020.core.utils.WebPages
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single<Preferences> { PreferencesImpl(androidApplication()) }
    single { PreferencesImpl(androidApplication()) }
}

val browserModule = module {
    single { WebPages(androidContext()) }
}