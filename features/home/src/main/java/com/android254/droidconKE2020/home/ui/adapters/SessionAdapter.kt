package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.home.databinding.HomeItemSessionBinding
import com.android254.droidconKE2020.home.utils.SessionsDiffUtilsCallback
import com.android254.droidconKE2020.R as appR

typealias OnSessionClick = (SessionUIModel) -> Unit
class SessionAdapter(private val onSessionClick: OnSessionClick) : ListAdapter<SessionUIModel, SessionAdapter.SessionViewHolder>(SessionsDiffUtilsCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeItemSessionBinding.inflate(inflater, parent, false)
        return SessionViewHolder(binding, onSessionClick)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        getItem(position)?.let { holder.bindSession(it, position) }
    }

    inner class SessionViewHolder(private val binding: HomeItemSessionBinding, private val onSessionClick: OnSessionClick) : RecyclerView.ViewHolder(binding.root) {

        fun bindSession(session: SessionUIModel, position: Int) {
            binding.sessionImg.apply {
                val colorId = if (position % 2 == 0) {
                    appR.color.colorBermudaFaded
                } else {
                    appR.color.colorYellowFaded
                }

                val bgColor = ContextCompat.getColor(context, colorId)
                setBackgroundColor(bgColor)
            }
            with(session) {
                binding.sessionUIModel = this
                binding.root.setOnClickListener { onSessionClick(this) }
            }
        }
    }
}