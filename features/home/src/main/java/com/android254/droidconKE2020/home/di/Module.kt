package com.android254.droidconKE2020.home.di

import com.android254.droidconKE2020.home.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModels = module {
    viewModel { HomeViewModel(get(), get(), get(), get(), get()) }
}

val homeRepositories = module {
    single { FakePromotionRepository() }
    single { FakeSessionRepository() }
    single { FakeSpeakerRepository() }
    single { FakeSponsorRepository() }
    single { FakeOrganizerRepository() }
}