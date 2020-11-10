package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Session
import com.android254.droidconKE2020.home.ui.views.HomeFragmentDirections
import kotlinx.android.synthetic.main.home_item_session.view.*
import com.android254.droidconKE2020.R as appR

class SessionAdapter : RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {

    private val sessions = mutableListOf<Session>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_session, parent, false)
        return SessionViewHolder(view)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val session = sessions[position]
        holder.bindSession(session, position)
    }

    fun updateData(list: List<Session>) {
        sessions.clear()
        sessions.addAll(list)
        notifyDataSetChanged()
    }

    inner class SessionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindSession(session: Session, position: Int) {
            view.sessionImg.apply {
                val colorId = if (position % 2 == 0) {
                    appR.color.colorBermudaFaded
                } else {
                    appR.color.colorYellowFaded
                }

                val bgColor = ContextCompat.getColor(context, colorId)
                setBackgroundColor(bgColor)
            }
            with(session) {
                view.imgAvatar.load(speaker.imageUrl)
                view.tvSessionTitle.text = "$title:"
                view.tvSessionDescription.text = description
                view.tvSpeakerName.text = speaker.name
                view.tvSpeakerDelegation.text =
                    "${speaker.work}${if (!speaker.company.isBlank()) ", " + speaker.company else ""}"
                view.time.text = time
                view.room.text = room
                view.description.text = description
                view.rootView.setOnClickListener { onSessionClicked(id) }
            }
        }

        private fun onSessionClicked(sessionId: Long) {
            val sessionDetailsAction =
                HomeFragmentDirections.actionHomeFragmentToSessionDetailsFragment(sessionId)
            view.findNavController().navigate(sessionDetailsAction)
        }
    }
}