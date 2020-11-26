package com.android254.droidconKE2020.feedback.di

import com.android254.droidconKE2020.feedback.ui.viewmodels.EventFeedbackViewModel
import org.koin.dsl.module

val feedbackModule = module {
    single { EventFeedbackViewModel(get()) }
}