package com.android254.droidconKE2020.about.di

import com.android254.droidconKE2020.about.ui.viewmodel.AboutViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * 29/03/20
 */
val aboutModule = module {
    viewModel { AboutViewModel() }
}