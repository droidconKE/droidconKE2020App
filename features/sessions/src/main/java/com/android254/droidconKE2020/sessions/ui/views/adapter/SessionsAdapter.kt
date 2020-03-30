package com.android254.droidconKE2020.sessions.ui.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.ItemSessionBinding

internal class SessionsAdapter(
    private val sessions: List<DummySession>,
    private val sessionClickListener: SessionClickListener,
    private val saveSessionListener: SaveSessionListener
) : RecyclerView.Adapter<SessionsAdapter.SessionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemSessionBinding = DataBindingUtil.inflate<ItemSessionBinding>(
            layoutInflater,
            R.layout.item_session,
            parent,
            false
        )
        return SessionsViewHolder(itemSessionBinding, sessionClickListener, saveSessionListener)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) =
        holder.bind(sessions[position])

    internal class SessionsViewHolder(
        private val itemSessionBinding: ItemSessionBinding,
        private val onSessionClickListener: SessionClickListener,
        private val onSaveSessionListener: SaveSessionListener
    ) : RecyclerView.ViewHolder(itemSessionBinding.root) {
        fun bind(session: DummySession) {
            with(itemSessionBinding) {
                this.session = session
                this.sessionClickListener = onSessionClickListener
                this.saveSessionListener = onSaveSessionListener
                this.executePendingBindings()
            }
        }
    }
}

