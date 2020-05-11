package com.android254.droidconKE2020.about.di

import com.android254.droidconKE2020.about.ui.viewmodel.AboutViewModel
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 * 29/03/20
 */
val aboutModule = module {
    viewModel { AboutViewModel() }
    viewModel { OrganizerViewModel() }
}

val loadModules by lazy {
    loadKoinModules(aboutModule)
}