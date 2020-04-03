package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Session
import kotlinx.android.synthetic.main.home_item_session.view.*

class SessionAdapter(private val onClicked: (Session) -> Unit) :
        RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {

    private val sessions = mutableListOf<Session>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item_session, parent, false)
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

    inner class SessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sessionImg = view.sessionImg
        val timeTxt = view.time
        val roomTxt = view.room
        val descriptionTxt = view.description
        val sessionCard = view.sessionCard

        fun bindSession(session: Session) {
            with(session) {
                timeTxt.text = time
                roomTxt.text = room
                descriptionTxt.text = description
                sessionCard.setOnClickListener {
                    onClicked.invoke(session)
                }
            }
        }
    }
}