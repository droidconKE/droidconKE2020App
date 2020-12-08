package com.android254.droidconKE2020.sessions.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.sessions.databinding.SessionItemSpeakerBinding
import com.android254.droidconKE2020.sessions.utils.SessionSpeakerDiffUtilCallback

typealias OnSpeakerClick = (SpeakerUIModel) -> Unit
class SessionSpeakersAdapter(private val onSpeakerClick: OnSpeakerClick) : ListAdapter<SpeakerUIModel, SessionSpeakersAdapter.SessionSpeakerViewHolder>(SessionSpeakerDiffUtilCallback()) {

    class SessionSpeakerViewHolder(private val binding: SessionItemSpeakerBinding, private val onSpeakerClick: OnSpeakerClick) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpeakerUIModel) {
            binding.speakerUIModel = item
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onSpeakerClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionSpeakerViewHolder {
        val binding = SessionItemSpeakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionSpeakerViewHolder(binding, onSpeakerClick)
    }

    override fun onBindViewHolder(holder: SessionSpeakerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}