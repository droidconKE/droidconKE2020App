package com.android254.droidconKE2020.sessions.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.sessions.R
import com.android254.droidconKE2020.sessions.databinding.ItemSessionBinding

internal class SessionsAdapter(
    private val sessions: List<SessionUIModel>,
    private val sessionsClickListener: SessionsClickListener,
) : RecyclerView.Adapter<SessionsAdapter.SessionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemSessionBinding = DataBindingUtil.inflate<ItemSessionBinding>(
            layoutInflater,
            R.layout.item_session,
            parent,
            false
        )
        return SessionsViewHolder(itemSessionBinding, sessionsClickListener)
    }

    override fun getItemCount(): Int = sessions.size

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) =
        holder.bind(sessions[position])

    internal class SessionsViewHolder(
        private val itemSessionBinding: ItemSessionBinding,
        private val onSessionClickListener: SessionsClickListener
    ) : RecyclerView.ViewHolder(itemSessionBinding.root) {
        fun bind(session: SessionUIModel) {
            with(itemSessionBinding) {
                this.sessionUIModel = session
                this.sessionsClickListener = onSessionClickListener
                this.executePendingBindings()
            }
        }
    }
}