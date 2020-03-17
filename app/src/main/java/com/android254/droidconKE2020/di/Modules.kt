package com.android254.droidconKE2020.di

import com.android254.droidconKE2020.DroidConKeApp
import com.android254.droidconKE2020.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

/**
 * 16/03/20
 * @author bernard
 */
val appModule = module {
    viewModel { LoginViewModel(get()) }
}
