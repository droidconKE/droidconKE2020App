package com.android254.droidconKE2020.auth

import android.content.Context
import com.android254.droidconKE2020.auth.viewModels.AuthFlow
import com.android254.droidconKE2020.auth.viewModels.AuthViewModel
import com.android254.droidconKE2020.auth.viewModels.GoogleAuthFlow
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { AuthViewModel(get(), get()) }
    single<AuthFlow> { (context: Context) -> GoogleAuthFlow(context, get()) }
}