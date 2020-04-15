package com.android254.droidconKE2020.speakers.di

import com.android254.droidconKE2020.speakers.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val speakersModule: Module = module {
    viewModel { SpeakerDetailsViewModel(get()) }
    viewModel { SpeakersViewModel(get()) }
    single { FakeSpeakerRepository() }
}
