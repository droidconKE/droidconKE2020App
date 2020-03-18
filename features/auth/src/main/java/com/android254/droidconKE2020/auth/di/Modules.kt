package com.android254.droidconKE2020.auth.di

import com.android254.droidconKE2020.auth.AuthViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * 17/03/20
 * @author bernard
 */
val authModule = module {
    viewModel { AuthViewModel(get()) }
}
