package com.android254.droidconKE2020.core.di

import com.android254.droidconKE2020.core.PreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single { PreferencesImpl(androidApplication()) }
}