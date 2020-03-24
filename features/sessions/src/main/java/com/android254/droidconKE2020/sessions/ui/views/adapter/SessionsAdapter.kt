package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.sessions.R
import kotlinx.android.synthetic.main.item_session.view.*

typealias SessionClickListener = (DummySession) -> Unit
internal class SessionsAdapter(
    private val sessions: List<DummySession>,
    private val context: Context,
    private val sessionClickListener: SessionClickListener
) : RecyclerView.Adapter<SessionsAdapter.SessionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
        return SessionsViewHolder(itemView, sessionClickListener, context)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) {
        holder.bind(sessions[position])
    }

    internal class SessionsViewHolder(
        itemView: View,
        private val sessionClickListener: SessionClickListener,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(session: DummySession) {
            with (session){
                itemView.imageViewStarSession.setOnClickListener {
                    context.displayToast("Session Saved")
                }
                itemView.cardViewSession.setOnClickListener {
                    sessionClickListener(this)
                }
                itemView.textViewSessionTitle.text = sessionTitle
                itemView.textViewSessionDescription.text = sessionDescription
                itemView.textViewSessionSpeaker.text = sessionSpeaker
                itemView.textViewSessionDuration.text =
                    String.format("%s - %s", sessionStartTime, sessionEndTime)
                itemView.textViewSessionStartTime.text = sessionStartTime?.replace("AM", "")
                itemView.textViewSessionVenue.text = sessionVenue
                itemView.textViewTimeZone.text = "AM"
            }

        }
    }

}

fun Context.displayToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}