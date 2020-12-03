package com.android254.droidconKE2020.repository

import com.android254.droidconKE2020.repository.feed.FeedRepository
import com.android254.droidconKE2020.repository.feed.FeedRepositoryImpl
import com.android254.droidconKE2020.repository.feedback.EventFeedbackRepository
import com.android254.droidconKE2020.repository.feedback.EventFeedbackRepositoryImpl
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.repository.sessions.SessionRepositoryImpl
import com.android254.droidconKE2020.repository.speakers.SpeakerRepository
import com.android254.droidconKE2020.repository.speakers.SpeakerRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
    single<FeedRepository> { FeedRepositoryImpl(get()) }
    single<EventFeedbackRepository> { EventFeedbackRepositoryImpl(get()) }
    single<SessionRepository> { SessionRepositoryImpl(get()) }
    single<SpeakerRepository> { SpeakerRepositoryImpl(get()) }
}