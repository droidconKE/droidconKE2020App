package com.android254.droidconKE2020.sessions.ui.views.di

import com.android254.droidconKE2020.repository.repoModule
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelsModule: Module = module {
    viewModel { SessionsViewModel(get()) }
}

val loadModules by lazy {
    loadKoinModules(listOf(viewModelsModule, repoModule))
}