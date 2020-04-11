package com.android254.droidconKE2020.repository.di

import com.android254.droidconKE2020.repository.repositories.FakeSpeakerRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val speakerReposModule: Module = module {
    single { FakeSpeakerRepository() }
}