package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
import com.android254.droidconKE2020.sessions.databinding.FragmentDaySessionsBinding
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
import com.android254.droidconKE2020.sessions.ui.views.adapter.SaveSessionListener
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionClickListener
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.BookmarkedSessionsViewModel
import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.*
import kotlinx.android.synthetic.main.fragment_day_sessions.*
import kotlinx.android.synthetic.main.fragment_filter.*
import org.koin.android.viewmodel.ext.android.viewModel


class BookmarkedSessionsFragment : Fragment() {
    private var _binding: FragmentBookmarkedSessionsBinding? = null
    private val binding get() = _binding!!
    private val bookmarkedSessionsViewModel: BookmarkedSessionsViewModel by viewModel()
    private fun injectFeatures() = loadModules

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkedSessionsBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeatures()
        getBookmarkedSessions()
        observeBookmarkedSessions()
        onNavigateBack()
        observeBackNavigation()
    }

    private fun onNavigateBack(){
        imageViewBackNavigation.setOnClickListener{ _ ->
            bookmarkedSessionsViewModel.onNavigateBack()

        }
    }

    private fun observeBackNavigation(){
        bookmarkedSessionsViewModel.isNavigateBack.observe(
            viewLifecycleOwner,
            Observer { isNavigateBack ->
                isNavigateBack?.let{
                    if (isNavigateBack) {
                        bookmarkedSessionsViewModel.onNavigatedBack()
                        findNavController().navigate(
                            BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment())
                    }
                }
            })

    }
    private  fun getBookmarkedSessions(){
        bookmarkedSessionsViewModel.getBookMarkedSessions()
    }
    private fun observeBookmarkedSessions() {
        bookmarkedSessionsViewModel.bookmarkedSessions.observe(
            viewLifecycleOwner,
            Observer {sessions ->
                setUpRvSessions(sessions)
            }
        )
    }

    private fun setUpRvSessions(sessions: List<DummySession>) {
        val sessionsAdapter = SessionsAdapter(
            sessions = sessions,
            saveSessionListener = SaveSessionListener { session, view ->
                session.isSessionSaved = false
            },
            sessionClickListener = SessionClickListener { sessionId ->
                //bookmarkedSessionsViewModel.onSessionItemClicked(sessionId = sessionId)
            }
        )
        binding.rvSessionsSavedSessions.adapter = sessionsAdapter
    }

}