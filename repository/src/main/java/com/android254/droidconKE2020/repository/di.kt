package com.android254.droidconKE2020.repository

import com.android254.droidconKE2020.repository.feed.FeedRepository
import com.android254.droidconKE2020.repository.feed.FeedRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
    single<FeedRepository> { FeedRepositoryImpl(get()) }
}