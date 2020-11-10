package com.android254.droidconKE2020.speakers.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBinding
import com.android254.droidconKE2020.speakers.models.Speaker
import com.google.android.material.chip.Chip

class SpeakerAdapter(val onSpeakerClicked: (Speaker) -> Unit) :
    ListAdapter<Speaker, RecyclerView.ViewHolder>(SpeakerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSpeakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val speaker = getItem(position)
        (holder as SpeakerViewHolder).bind(speaker)
    }

    inner class SpeakerViewHolder(private val binding: ItemSpeakerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Speaker) {
            binding.speaker = item
            binding.executePendingBindings()
            binding.setOpenSpeakerDetails { onSpeakerClicked.invoke(item) }

            item.skills.forEach { skill ->
                binding.cgSkills.addView(
                    Chip(binding.cgSkills.context)
                        .also {
                            it.text = skill
                            it.isClickable = false
                            it.setTextAppearance(android.R.style.TextAppearance_Material_Caption)
                            it.chipBackgroundColor = ContextCompat.getColorStateList(
                                it.context,
                                com.android254.droidconKE2020.R.color.colorAquaMarineFaded
                            )
                        }
                )
            }
        }
    }

    class SpeakerDiffCallback : DiffUtil.ItemCallback<Speaker>() {

        override fun areItemsTheSame(oldItem: Speaker, newItem: Speaker): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Speaker, newItem: Speaker): Boolean =
            oldItem == newItem
    }
}