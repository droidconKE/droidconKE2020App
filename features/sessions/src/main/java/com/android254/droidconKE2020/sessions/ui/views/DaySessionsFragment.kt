package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentDaySessionsBinding
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsClickListener
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DaySessionsFragment : Fragment(R.layout.fragment_day_sessions), SessionsClickListener {
    private fun injectFeatures() = loadModules
    private val sessionsViewModel: SessionsViewModel by sharedViewModel()
    private var _binding: FragmentDaySessionsBinding? = null
    private val binding get() = _binding!!
    private var sessionsAdapter: SessionsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaySessionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeatures()
        super.onViewCreated(view, savedInstanceState)
        observeDaySessions()
        lifecycleScope.launchWhenStarted {
            sessionsViewModel.fetchSessions(arguments?.getString("day").orEmpty())
        }

    }

    private fun observeDaySessions() {
        sessionsViewModel.sessions.observe(viewLifecycleOwner) { sessions ->
            setUpRvSessions(sessions)
        }

        sessionsViewModel.showToast.observe(viewLifecycleOwner) { errorMessage ->
            requireContext().toast(errorMessage)
        }

        sessionsViewModel.isSessionBookmarked.observe(viewLifecycleOwner) { isSessionBookmarked ->
            requireContext().toast(isSessionBookmarked)
        }
    }


    private fun setUpRvSessions(sessions: List<SessionUIModel>) {
        sessionsAdapter = SessionsAdapter(sessions, this)
        binding.rvSessions.adapter = sessionsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(day: String): DaySessionsFragment = DaySessionsFragment().also {
            val args = Bundle()
            args.putString("day", day)
            it.arguments = args
        }
    }

    override fun onSessionClick(sessionUIModel: SessionUIModel) {
        val sessionsDirections = SessionsFragmentDirections.actionSessionsFragmentToSessionDetailFragment(
            sessionUIModel
        )
        findNavController().navigate(sessionsDirections)
    }

    override fun onSessionSave(sessionUIModel: SessionUIModel, view: View) {
        sessionUIModel.isBookmarked = !sessionUIModel.isBookmarked
        binding.rvSessions.adapter?.notifyDataSetChanged()
        sessionsViewModel.changeBookmarkStatus(sessionUIModel.sessionId)
    }
}