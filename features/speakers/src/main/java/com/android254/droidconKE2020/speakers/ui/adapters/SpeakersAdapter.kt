package com.android254.droidconKE2020.speakers.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBinding
import com.android254.droidconKE2020.speakers.utils.SpeakerDiffCallback

class SpeakersAdapter(val onSpeakerClicked: (SpeakerUIModel) -> Unit) :
    PagingDataAdapter<SpeakerUIModel, SpeakersAdapter.SpeakerViewHolder>(SpeakerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val binding = ItemSpeakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class SpeakerViewHolder(private val binding: ItemSpeakerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpeakerUIModel) {
            binding.speaker = item
            binding.executePendingBindings()
            binding.setOpenSpeakerDetails { onSpeakerClicked.invoke(item) }

//            item.skills.forEach { skill ->
//                binding.cgSkills.addView(
//                    Chip(binding.cgSkills.context)
//                        .also {
//                            it.text = skill
//                            it.isClickable = false
//                            it.setTextAppearance(android.R.style.TextAppearance_Material_Caption)
//                            it.chipBackgroundColor = ContextCompat.getColorStateList(
//                                it.context,
//                                com.android254.droidconKE2020.R.color.colorAquaMarineFaded
//                            )
//                        }
//                )
//            }
        }
    }
}