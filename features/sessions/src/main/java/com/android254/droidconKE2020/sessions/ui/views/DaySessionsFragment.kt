package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
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
        fetchSessions(arguments?.getString("day").orEmpty())
        observeDaySessions()
    }

    private fun fetchSessions(day: String) {
        sessionsViewModel.fetchSessions(day)
    }

    private fun observeDaySessions() {
        sessionsViewModel.sessions.observe(viewLifecycleOwner) { sessions ->
            if (parentFragment is BookmarkedSessionsFragment){
                val savedSessions = sessions.filter { it.isBookmarked }
                if (savedSessions.isNullOrEmpty()){
                    binding.noSessionsView.visibility = View.VISIBLE
                    binding.rvSessions.visibility = View.GONE
                }else{
                    binding.noSessionsView.visibility = View.GONE
                    binding.rvSessions.visibility = View.VISIBLE
                    setUpRvSessions(savedSessions)
                }
            }else{
                setUpRvSessions(sessions)
            }
        }
        sessionsViewModel.showToast.observe(viewLifecycleOwner) { errorMessage ->
            requireContext().toast(errorMessage)
        }
        sessionsViewModel.isSessionBookmarked.observe(viewLifecycleOwner) { isSessionBookmarked ->
            requireContext().toast(isSessionBookmarked)
        }
    }

    private fun setUpRvSessions(sessions: List<SessionUIModel>) {
        val sessionsAdapter = SessionsAdapter(sessions, this)
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
        var directions: NavDirections = if (parentFragment is BookmarkedSessionsFragment) {
            BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionDetailsFragment(
                sessionUIModel
            )
        }else{
            SessionsFragmentDirections.actionSessionsFragmentToSessionDetailFragment(
                sessionUIModel
            )
        }
        findNavController().navigate(directions)
    }

    override fun onSessionSave(sessionUIModel: SessionUIModel, view: View) {
        sessionUIModel.isBookmarked = !sessionUIModel.isBookmarked
        binding.rvSessions.adapter?.notifyDataSetChanged()
        sessionsViewModel.changeBookmarkStatus(sessionUIModel.sessionId)
    }
}