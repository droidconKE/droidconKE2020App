package com.android254.droidconKE2020.speakers.utils

import androidx.recyclerview.widget.DiffUtil
import com.android254.droidconKE2020.core.models.SpeakerUIModel

class SpeakerDiffCallback : DiffUtil.ItemCallback<SpeakerUIModel>() {

    override fun areItemsTheSame(oldItem: SpeakerUIModel, newItem: SpeakerUIModel): Boolean =
        oldItem.speakerName == newItem.speakerName && oldItem.speakerBio == newItem.speakerBio && oldItem.speakerAvatar == newItem.speakerAvatar

    override fun areContentsTheSame(oldItem: SpeakerUIModel, newItem: SpeakerUIModel): Boolean =
        oldItem == newItem
}