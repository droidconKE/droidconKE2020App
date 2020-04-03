package com.android254.droidconKE2020.home.di

import com.android254.droidconKE2020.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel() }
}