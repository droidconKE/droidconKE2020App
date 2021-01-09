package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
import com.android254.droidconKE2020.sessions.databinding.FragmentDaySessionsBinding
import com.android254.droidconKE2020.sessions.ui.views.adapter.*
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
import com.android254.droidconKE2020.sessions.ui.views.models.DaySession
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.BookmarkedSessionsViewModel
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionsViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.*
import kotlinx.android.synthetic.main.tab_session.view.*

import org.koin.android.viewmodel.ext.android.viewModel


class BookmarkedSessionsFragment : Fragment() {
    private var _binding: FragmentBookmarkedSessionsBinding? = null
    private lateinit var sessionsTabAdapter: SessionsTabAdapter
    private val binding get() = _binding!!
    private val bookmarkedSessionsViewModel: BookmarkedSessionsViewModel by viewModel()
    private val sessionsViewModel: SessionsViewModel by viewModel()
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
        getDaySessions()
        observeDaySessions()
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

    private fun setUpTabs(daySessions: List<DaySession>) {
        daySessions.forEach{ daySession->
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_session, null)
            tabView.textViewDayDate.text = daySession.date
            tabView.textViewDayName.text = daySession.dayText
            tabView.textViewDayName.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    com.android254.droidconKE2020.R.color.colorGreen
                )
            )
            tabView.layoutTabSession.background =
                requireContext().resources.getDrawable(R.drawable.session_card_view_border, null)
            binding.tabLayout.addTab(tabLayout.newTab().setCustomView(tabView))
        }
        //TODO: what should happen when I click on one of them?
    }

    private fun observeDaySessions() {
        sessionsViewModel.daySessions.observe(
            viewLifecycleOwner,
            Observer { daySessions ->
                Log.d("Sessions", "are $daySessions")
                if (daySessions.isNotEmpty()) {
                    setUpTabs(daySessions)
                }
            }
        )
    }
    private fun getDaySessions() {
        sessionsViewModel.getDaySessions()
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