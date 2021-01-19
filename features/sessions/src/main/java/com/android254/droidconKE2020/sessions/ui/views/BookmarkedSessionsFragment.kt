package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.sessions.databinding.FragmentBookmarkedSessionsBinding
import com.android254.droidconKE2020.sessions.di.loadModules
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.adapter.SessionsClickListener
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import kotlinx.android.synthetic.main.fragment_bookmarked_sessions.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class BookmarkedSessionsFragment : Fragment(), SessionsClickListener {
    private var _binding: FragmentBookmarkedSessionsBinding? = null
    private val binding get() = _binding!!
    private val sessionsViewModel: SessionsViewModel by sharedViewModel()
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
        observeSavedSessions()

    }

    private fun observeSavedSessions(){
        sessionsViewModel.sessions.observe(viewLifecycleOwner) { sessions ->
            if(sessions != null){
                //TODO: Maybe move this to viewModel
                val savedSessions = sessions.filter { it.isBookmarked}
                setUpRvSessions(savedSessions)
            }else{
                Log.d("Sessions", "Null/empty")
            }
        }
    }

        private fun setUpRvSessions(sessions: List<SessionUIModel>) {
            val sessionsAdapter = SessionsAdapter(sessions, this)
            binding.rvSessionsSavedSessions.adapter = sessionsAdapter
        }

//    private fun setUpTabs(daySessions: List<DaySession>) {
//        daySessions.forEach { daySession ->
//            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_session, null)
//            tabView.textViewDayDate.text = daySession.date
//            tabView.textViewDayName.text = daySession.dayText
//            tabView.textViewDayName.setTextColor(
//                ContextCompat.getColor(
//                    requireContext(),
//                    com.android254.droidconKE2020.R.color.colorGreen
//                )
//            )
//            tabView.layoutTabSession.background =
//                requireContext().resources.getDrawable(R.drawable.session_card_view_border, null)
//            binding.tabLayout.addTab(tabLayout.newTab().setCustomView(tabView))
//        }
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val bookmarkedSessionsFragmentDirections =
//                    BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment()
//                findNavController().navigate( bookmarkedSessionsFragmentDirections)
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {}
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//        })
//    }

//    private fun observeDaySessions() {
//        sessionsViewModel.daySessions.observe(
//            viewLifecycleOwner,
//            Observer { daySessions ->
//                if (daySessions.isNotEmpty()) {
//                    setUpTabs(daySessions)
//                }
//            }
//        )
//    }
//
//    private fun getDaySessions() {
//        sessionsViewModel.getDaySessions()
//    }

    private fun onNavigateBack() {
        imageViewBackNavigation.setOnClickListener { _ ->
        }
    }

    override fun onSessionClick(sessionUIModel: SessionUIModel) {
        Log.d("Sessions", "Item click")
    }

    override fun onSessionSave(sessionUIModel: SessionUIModel, view: View) {
        Log.d("Sessions", "Item unsave")
    }

//    private fun observeBackNavigation() {
//        bookmarkedSessionsViewModel.isNavigateBack.observe(
//            viewLifecycleOwner,
//            Observer { isNavigateBack ->
//                isNavigateBack?.let {
//                    if (isNavigateBack) {
//                        bookmarkedSessionsViewModel.onNavigatedBack()
//                        val bookmarkedSessionsFragmentDirections =
//                            BookmarkedSessionsFragmentDirections.actionBookmarkedSessionsFragmentToSessionsFragment()
//                        findNavController().navigate(bookmarkedSessionsFragmentDirections)
//                    }
//                }
//            })
//    }




//    private fun setUpRvSessions(sessions: List<DummySession>) {
//        val sessionsAdapter = SessionsAdapter(
//            sessions = sessions,
//            saveSessionListener = SaveSessionListener { session, view ->
//                session.isSessionSaved = false
//            },
//            sessionClickListener = SessionClickListener { sessionId ->
//                bookmarkedSessionsViewModel.onSessionItemClicked(sessionId = sessionId)
//            }
//        )
//        binding.rvSessionsSavedSessions.adapter = sessionsAdapter
//    }




}