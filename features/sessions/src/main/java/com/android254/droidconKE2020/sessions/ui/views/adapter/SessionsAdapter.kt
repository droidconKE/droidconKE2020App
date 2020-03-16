package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.sessions.R
import kotlinx.android.synthetic.main.item_session.view.*

internal class SessionsAdapter(
    private val sessions: List<DummySession>,
    val onSessionClickListener: OnSessionClickListener
) : RecyclerView.Adapter<SessionsAdapter.SessionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
        return SessionsViewHolder(itemView, onSessionClickListener)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) {
        holder.bind(sessions[position])
    }

    internal class SessionsViewHolder(
        itemView: View,
        private val onSessionClickListener: OnSessionClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(session: DummySession) {
            itemView.textViewSessionTitle.text = session.sessionTitle
            itemView.textViewSessionDescription.text = session.sessionDescription
            itemView.textViewSessionSpeaker.text = session.sessionSpeaker
            itemView.textViewSessionDuration.text =
                String.format("%s - %s", session.sessionStartTime, session.sessionEndTime)
            itemView.textViewSessionStartTime.text = session.sessionStartTime?.replace("AM", "")
            itemView.textViewSessionVenue.text = session.sessionVenue
        }
    }

}