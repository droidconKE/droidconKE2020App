package com.android254.droidconKE2020.feedback.ui.views

import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.feedback.R
import com.android254.droidconKE2020.feedback.di.feedbackModule
import com.android254.droidconKE2020.repository.repoModule
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(feedbackModule, repoModule)) }
private fun injectFeature() = loadFeature

class FeedbackFragment : Fragment(){

}