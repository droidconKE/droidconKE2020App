package com.android254.droidconKE2020.feedback.ui.views

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.feedback.databinding.FragmentSessionFeedbackBinding
import com.android254.droidconKE2020.feedback.di.feedbackModule
import com.android254.droidconKE2020.feedback.ui.viewmodels.SessionFeedbackViewModel
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.repoModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(feedbackModule, repoModule)) }
private fun injectFeature() = loadFeature

class SessionFeedbackFragment : Fragment() {
    private var _binding: FragmentSessionFeedbackBinding? = null
    private val binding get() = _binding!!
    private val sessionFeedbackViewModel : SessionFeedbackViewModel by viewModel()
    private val sessionFeedbackFragmentArgs : SessionFeedbackFragmentArgs by navArgs()
    private val sessionSlug : String by lazy {
        sessionFeedbackFragmentArgs.sessionSlug
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLiveData()
        binding.btnSubmitFeedback.setOnClickListener {
            val feedback = binding.etFeedback.text.toString()
            val rating = binding.sessionRatingBar.rating.toInt()
            binding.mainLayout.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            submitEventFeedback(feedback, rating)
        }
    }

    private fun observeLiveData() {
        sessionFeedbackViewModel.sessionFeedback.observe(viewLifecycleOwner) { submitFeedbackResponse ->
           requireContext().toast(submitFeedbackResponse)
        }
        sessionFeedbackViewModel.showToast.observe(viewLifecycleOwner){ errorMessage ->
            requireContext().toast(errorMessage)
        }

    }

    private fun submitEventFeedback(feedback: String, rating: Int) {
        if (isValidInputs(feedback, rating)) {
            sessionFeedbackViewModel.submitSessionFeedback(sessionSlug,feedback, rating)
        } else {
            requireContext().toast("Please enter you feedback")
        }
    }

    private fun isValidInputs(feedback: String, rating: Int): Boolean {
        var isValid = false
        !TextUtils.isEmpty(feedback)
        isValid = rating > 0
        return isValid
    }
}