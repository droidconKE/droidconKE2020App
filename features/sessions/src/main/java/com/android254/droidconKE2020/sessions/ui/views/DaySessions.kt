package com.android254.droidconKE2020.sessions.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
import com.android254.droidconKE2020.sessions.ui.views.adapter.OnSessionClickListener
import com.android254.droidconKE2020.sessions.ui.views.adapter.SessionsAdapter
import kotlinx.android.synthetic.main.fragment_day_sessions.*

/**
 * A simple [Fragment] subclass.
 */
internal class DaySessions(day: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day_sessions, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRvSessions()
    }

    private fun setUpRvSessions() {
        val sessions = listOf(
            DummySession(
                sessionSpeaker = "James Kirwa",
                sessionTitle = "Coroutines In Depth",
                sessionVenue = "Twiga Foods",
                sessionDescription = "A beginner guide to asynchronous programming",
                sessionStartTime = "9:00 AM",
                sessionEndTime = "9:30 AM"
            ), DummySession(
                sessionSpeaker = "Jake Wharton",
                sessionTitle = "Retrofit",
                sessionVenue = "ROOM 2",
                sessionDescription = "Let's retrofit",
                sessionStartTime = "9:30 AM",
                sessionEndTime = "10:30 AM"
            ), DummySession(
                sessionSpeaker = "Chris Banes",
                sessionTitle = "Kotlin Flows",
                sessionVenue = "ROOM 3",
                sessionDescription = "Flowing in Kotlin",
                sessionStartTime = "11:00 AM",
                sessionEndTime = "11:30 AM"
            ), DummySession(
                sessionSpeaker = "Juma Allan",
                sessionTitle = "Android Modularization",
                sessionVenue = "ROOM 2",
                sessionDescription = "Modularization:The Branch Story",
                sessionStartTime = "12:00 AM",
                sessionEndTime = "12:30 AM"
            ), DummySession(
                sessionSpeaker = "Android Maestro",
                sessionTitle = "Invalidate caches/ restart",
                sessionVenue = "Room 4",
                sessionDescription = "How to be a rockstar developer",
                sessionStartTime = "2:00 AM",
                sessionEndTime = "2:30 AM"
            )
        )
        val sessionsAdapter = SessionsAdapter(sessions = sessions, onSessionClickListener = object :
            OnSessionClickListener {
            override fun clickItem(session: DummySession, v: View) {}

        }, context = requireContext())
        rvSessions.adapter = sessionsAdapter
    }

    companion object {
        fun newInstance(day: String): DaySessions = DaySessions(day)
    }

}
