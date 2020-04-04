package com.android254.droidconKE2020.auth.di

import com.android254.droidconKE2020.auth.viewModels.AuthViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val authModule: Module = module {
    viewModel { AuthViewModel()}
}