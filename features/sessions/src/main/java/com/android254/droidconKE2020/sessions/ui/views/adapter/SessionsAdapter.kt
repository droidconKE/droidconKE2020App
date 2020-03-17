package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.sessions.R
import kotlinx.android.synthetic.main.item_session.view.*

internal class SessionsAdapter(
    private val sessions: List<DummySession>,
    val onSessionClickListener: OnSessionClickListener,
    private val context: Context
) : RecyclerView.Adapter<SessionsAdapter.SessionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
        return SessionsViewHolder(itemView, onSessionClickListener, context)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) {
        holder.bind(sessions[position])
    }

    internal class SessionsViewHolder(
        itemView: View,
        private val onSessionClickListener: OnSessionClickListener,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(session: DummySession) {
            itemView.imageViewStarSession.setOnClickListener {
                context.displayToast("Session Saved")
            }
            itemView.cardViewSession.setOnClickListener {
                context.displayToast(session.sessionTitle.toString())
                onSessionClickListener.clickItem(session, itemView)
            }
            itemView.textViewSessionTitle.text = session.sessionTitle
            itemView.textViewSessionDescription.text = session.sessionDescription
            itemView.textViewSessionSpeaker.text = session.sessionSpeaker
            itemView.textViewSessionDuration.text =
                String.format("%s - %s", session.sessionStartTime, session.sessionEndTime)
            itemView.textViewSessionStartTime.text = session.sessionStartTime?.replace("AM", "")
            itemView.textViewSessionVenue.text = session.sessionVenue
            itemView.textViewTimeZone.text = "AM"
        }
    }

}

fun Context.displayToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}