package com.android254.droidconKE2020.speakers.di

import com.android254.droidconKE2020.speakers.viewmodels.FakeSpeakerRepository
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import com.android254.droidconKE2020.speakers.views.viewmodels.SpeakerDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val speakerModule: Module = module {
    viewModel { SpeakerDetailsViewModel() }
}

val speakersModule = module {
    viewModel { SpeakersViewModel(get()) }
//    speakerRepositories
}

val speakerRepositories = module {
    single { FakeSpeakerRepository() }
}