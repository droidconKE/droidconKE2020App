package com.android254.droidconKE2020.feedback.ui.views

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.feedback.databinding.FragmentFeedbackBinding
import com.android254.droidconKE2020.feedback.di.feedbackModule
import com.android254.droidconKE2020.feedback.ui.viewmodels.EventFeedbackViewModel
import com.android254.droidconKE2020.repository.repoModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(feedbackModule, repoModule)) }
private fun injectFeature() = loadFeature

class FeedbackFragment : Fragment(){
    private val eventFeedbackViewModel: EventFeedbackViewModel by viewModel()
    private var _binding: FragmentFeedbackBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventFeedbackViewModel.submitFeedback.observe(viewLifecycleOwner){ message ->
            requireContext().toast(message)
        }

        binding.btnSubmitFeedback.setOnClickListener {
            val feedback = binding.etFeedback.text.toString()
            val rating = binding.eventRatingBar.rating.toString()
            submitEventFeedback(feedback, rating)
        }
    }

    private fun submitEventFeedback(feedback: String, rating: String) {
        if (isValidInputs(feedback, rating)){
            eventFeedbackViewModel.sendEventFeedback(feedback, rating)
        }else{
            requireContext().toast("Please enter you feedback")
        }

    }

    private fun isValidInputs(feedback: String, rating: String) : Boolean{
        var isValid = false
        !TextUtils.isEmpty(feedback)
        isValid = !TextUtils.isEmpty(rating)

        return isValid
    }
}