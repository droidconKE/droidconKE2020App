package com.android254.droidconKE2020.feed.ui.views

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val feedModule: Module = module {
    viewModel { FeedViewModel(get()) }
}