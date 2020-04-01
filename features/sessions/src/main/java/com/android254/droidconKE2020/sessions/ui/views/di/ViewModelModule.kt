package com.android254.droidconKE2020.sessions.ui.views.di

import com.android254.droidconKE2020.sessions.ui.views.viewmodel.DaySessionsViewModel
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionDetailViewModel
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelsModule: Module = module {
    viewModel<DaySessionsViewModel> {
        DaySessionsViewModel()
    }
    viewModel<SessionsViewModel> {
        SessionsViewModel()
    }
    viewModel<SessionDetailViewModel> {
        SessionDetailViewModel()
    }
}

val loadModules by lazy {
    loadKoinModules(viewModelsModule)
}