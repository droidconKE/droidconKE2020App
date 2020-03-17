package com.android254.droidconKE2020.auth.di

import com.android254.droidconKE2020.auth.login.LoginViewModel
import org.koin.dsl.module

/**
 * 17/03/20
 * @author bernard
 */
val authModule = module {
    single { LoginViewModel(get()) }
}
