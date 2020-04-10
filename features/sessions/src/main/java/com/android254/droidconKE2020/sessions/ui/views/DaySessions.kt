package com.android254.droidconKE2020.sessions.ui.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.R as AppR
import com.android254.droidconKE2020.sessions.databinding.FragmentDaySessionsBinding
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
import com.android254.droidconKE2020.sessions.ui.views.adapter.SaveSessionListener
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionClickListener
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsAdapter
import com.android254.droidconKE2020.sessions.ui.views.di.loadModules
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.DaySessionsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class DaySessions : Fragment(R.layout.fragment_day_sessions) {


    private fun injectFeatures() = loadModules
    private val daySessionsViewModel: DaySessionsViewModel by viewModel()
    private var _binding: FragmentDaySessionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDaySessionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectFeatures()
        super.onViewCreated(view, savedInstanceState)
        getDaySessions()
        observeDaySessions()
        observeNavigateToSessionDetail()
        observeSaveSessionItem()
    }

    private fun observeDaySessions() {
        daySessionsViewModel.daySessions.observe(viewLifecycleOwner, Observer { sessions ->
            if (sessions.isNotEmpty()) {
                setUpRvSessions(sessions)
            }
        })
    }

    private fun observeNavigateToSessionDetail() {
        daySessionsViewModel.navigateToSessionDetail.observe(
            viewLifecycleOwner,
            Observer { sessionId ->
                sessionId?.let {
                    val sessionsFragmentDirections =
                        SessionsFragmentDirections.actionSessionsFragmentToSessionDetailFragment(
                            sessionId
                        )
                    findNavController().navigate(sessionsFragmentDirections)
                    daySessionsViewModel.onSessionDetailNavigated()
                }
            })
    }

    private fun observeSaveSessionItem() {
        daySessionsViewModel.saveSessionItem.observe(viewLifecycleOwner, Observer { session ->
            session?.let {
                if (session.isSessionSaved) {
                    requireContext().displayToast(" ${session.sessionTitle} Unsaved")
                    daySessionsViewModel.onSessionItemSaved()
                } else {
                    requireContext().displayToast(" ${session.sessionTitle} Saved")
                    daySessionsViewModel.onSessionItemSaved()
                }
            }
        })
    }

    private fun setUpRvSessions(sessions: List<DummySession>) {
        val sessionsAdapter = SessionsAdapter(
            sessions = sessions,
            saveSessionListener = SaveSessionListener { session, view ->
                daySessionsViewModel.onSaveSessionItemClicked(session = session)
                if (session.isSessionSaved) {
                    session.isSessionSaved = false
                    (view as ImageView).setImageDrawable(
                        resources.getDrawable(
                            R.drawable.ic_star_outline,
                            null
                        )
                    )
                } else {
                    session.isSessionSaved = true
                    (view as ImageView).setImageDrawable(
                        resources.getDrawable(
                            AppR.drawable.ic_star,
                            null
                        )
                    )
                }
            },
            sessionClickListener = SessionClickListener { sessionId ->
                daySessionsViewModel.onSessionItemClicked(sessionId = sessionId)
            })
        binding.rvSessions.adapter = sessionsAdapter
    }

    private fun getDaySessions() {
        daySessionsViewModel.getDaySessions(arguments?.getString("day").orEmpty())
    }

    companion object {
        fun newInstance(day: String): DaySessions = DaySessions().also {
            val args = Bundle()
            args.putString("day", day)
            it.arguments = args
        }
    }

}

fun Context.displayToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

