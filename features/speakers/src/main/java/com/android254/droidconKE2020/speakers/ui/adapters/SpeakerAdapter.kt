package com.android254.droidconKE2020.speakers.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBinding
import com.android254.droidconKE2020.speakers.models.Speaker

class SpeakerAdapter() : ListAdapter<Speaker, RecyclerView.ViewHolder>(SpeakerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSpeakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val speaker = getItem(position)
    }

    class SpeakerViewHolder(binding: ItemSpeakerBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    class SpeakerDiffCallback : DiffUtil.ItemCallback<Speaker>() {

        override fun areItemsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
            return oldItem == newItem
        }
    }
}
