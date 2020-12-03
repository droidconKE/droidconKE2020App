package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionDetailBinding
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class SessionDetailFragment : Fragment(R.layout.fragment_session_detail) {
    private fun injectFeatures() = loadModules
    private var _binding: FragmentSessionDetailBinding? = null
    private val binding get() = _binding!!
    private val sessionsViewModel: SessionsViewModel by sharedViewModel()
    lateinit var sessionUiModel : SessionUIModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        injectFeatures()
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.sessionsViewModel = sessionsViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionsViewModel.sessionUIModel.observe(viewLifecycleOwner){ sessionModel ->
            sessionUiModel = sessionModel
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.textViewFeedback.setOnClickListener {
            findNavController().navigate(SessionsFragmentDirections.actionSessionsFragmentToSessionFeedbackFragment(sessionUiModel.sessionSlug))
        }
    }
}