package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.home.databinding.HomeItemSpeakerBinding
import com.android254.droidconKE2020.home.utils.SpeakerDiffUtilsCallback

typealias OnSpeakerClicked = (SpeakerUIModel) -> Unit

class SpeakerAdapter(private val onSpeakerClicked: OnSpeakerClicked) :
    ListAdapter<SpeakerUIModel, SpeakerAdapter.SpeakerViewHolder>(SpeakerDiffUtilsCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpeakerAdapter.SpeakerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeItemSpeakerBinding.inflate(inflater, parent, false)
        return SpeakerViewHolder(binding, onSpeakerClicked)
    }

    override fun onBindViewHolder(holder: SpeakerAdapter.SpeakerViewHolder, position: Int) {
        getItem(position)?.let { holder.bindSpeaker(it) }
    }

    inner class SpeakerViewHolder(
        private val binding: HomeItemSpeakerBinding,
        private val onSpeakerClicked: OnSpeakerClicked
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindSpeaker(speaker: SpeakerUIModel) {
            with(speaker) {
                binding.speakerUIModel = this
                binding.root.setOnClickListener { onSpeakerClicked(this) }
            }
        }
    }
}