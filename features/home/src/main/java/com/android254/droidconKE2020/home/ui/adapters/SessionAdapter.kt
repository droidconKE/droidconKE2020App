package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Session
import com.android254.droidconKE2020.home.ui.views.HomeFragmentDirections
import kotlinx.android.synthetic.main.home_item_session.view.*

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
        holder.bindSession(session)
    }

    fun updateData(list: List<Session>) {
        sessions.clear()
        sessions.addAll(list)
        notifyDataSetChanged()
    }

    inner class SessionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindSession(session: Session) {
            with(session) {
                view.sessionImg.load(imageUrl.toInt()) // ToDo: Remove the int cast upon introducing real data
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