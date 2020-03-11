package com.android254.droidconKE2020.home.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.home.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_session.view.*

class SessionAdapter(private val onClicked: (Session) -> Unit) :
    RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {

    private val sessions = mutableListOf<Session>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
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
        val sessionImg: ImageView
        val timeTxt: TextView
        val roomTxt: TextView
        val descriptionTxt: TextView
        val sessionCard: MaterialCardView

        init {
            sessionImg = view.sessionImg
            timeTxt = view.time
            roomTxt = view.room
            descriptionTxt = view.description
            sessionCard = view.sessionCard
        }

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