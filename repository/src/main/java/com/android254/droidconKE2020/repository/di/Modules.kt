package com.android254.droidconKE2020.repository.di

import com.android254.droidconKE2020.repository.user.UserRepository
import org.koin.dsl.module

/**
 * 17/03/20
 * @author bernard
 */
val repositoryModule = module {
    factory { UserRepository(get(), get()) }
}
