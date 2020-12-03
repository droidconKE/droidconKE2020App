package com.android254.droidconKE2020.feedback.di

import com.android254.droidconKE2020.feedback.ui.viewmodels.EventFeedbackViewModel
import com.android254.droidconKE2020.feedback.ui.viewmodels.SessionFeedbackViewModel
import org.koin.dsl.module

val feedbackModule = module {
    single { EventFeedbackViewModel(get()) }
    single { SessionFeedbackViewModel(get()) }
}