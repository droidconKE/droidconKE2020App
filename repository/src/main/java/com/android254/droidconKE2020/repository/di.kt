package com.android254.droidconKE2020.repository

import org.koin.dsl.module

val repoModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
}