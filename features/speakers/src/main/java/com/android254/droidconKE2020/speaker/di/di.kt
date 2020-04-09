package com.android254.droidconKE2020.speaker.di

import com.android254.droidconKE2020.speaker.views.viewmodels.SpeakerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val speakerModule: Module = module {
    viewModel { SpeakerViewModel() }
}