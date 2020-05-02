package com.android254.droidconKE2020.sessions.ui.views


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentSessionDetailBinding
import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import com.android254.droidconKE2020.R as AppR


/**
 * A simple [Fragment] subclass.
 */
class SessionDetailFragment : Fragment(R.layout.fragment_session_detail) {
    private fun injectFeatures() = loadModules
    private var _binding: FragmentSessionDetailBinding? = null
    private val binding get() = _binding!!
    private val sessionDetailViewModel: SessionDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        injectFeatures()
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.sessionDetailViewModel = sessionDetailViewModel
        getSessionDetail()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSaveSession()
        observeClickSpeaker()
        observerShareSession()
        observerNavigateBack()
    }

    private fun observerShareSession() {
        sessionDetailViewModel.shareSession.observe(viewLifecycleOwner, Observer { session ->
            session?.let {
                Log.d("Fragment Tag", "We are here")
                val shareSessionBottomFragment = ShareSessionBottomFragment(session)
                shareSessionBottomFragment.show(parentFragmentManager, "Share Session")
                sessionDetailViewModel.onSessionShared()
            }
        })
    }

    private fun observeSaveSession() {
        sessionDetailViewModel.saveSession.observe(viewLifecycleOwner, Observer { sessionDetail ->
            sessionDetail?.let {
                if (sessionDetail.isSaved) {
                    binding.imageViewSave.setImageDrawable(
                        resources.getDrawable(
                            R.drawable.ic_star_outline,
                            null
                        )
                    )
                    it.isSaved = false
                    sessionDetailViewModel.onSessionSaved()
                } else {
                    binding.imageViewSave.setImageDrawable(
                        resources.getDrawable(
                            AppR.drawable.ic_star,
                            null
                        )
                    )
                    it.isSaved = true
                    sessionDetailViewModel.onSessionSaved()
                }
            }
        })
    }

    private fun observerNavigateBack() {
        sessionDetailViewModel.navigateBack.observe(viewLifecycleOwner, Observer { navigateBack ->
            navigateBack?.let {
                if (navigateBack) {
                    sessionDetailViewModel.onNavigatedBack()
                    findNavController().navigate(SessionDetailFragmentDirections.actionSessionDetailsFragmentToSessionsFragment())
                }
            }
        })
    }

    private fun observeClickSpeaker() {
        sessionDetailViewModel.clickSpeaker.observe(viewLifecycleOwner, Observer {
            it?.let {
                sessionDetailViewModel.onSpeakerClicked()
                val speakerDetailsAction =
                    SessionDetailFragmentDirections.actionSessionDetailsFragmentToSpeakerDetailsFragment(
                        it
                    )
                findNavController().navigate(speakerDetailsAction)
            }
        })
    }

    private fun getSessionDetail() {
        sessionDetailViewModel.getSessionDetails(
            SessionDetailFragmentArgs.fromBundle(
                requireArguments()
            ).sessionId
        )
    }
}
