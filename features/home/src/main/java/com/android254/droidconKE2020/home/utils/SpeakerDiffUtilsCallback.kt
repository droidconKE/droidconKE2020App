package com.android254.droidconKE2020.home.utils

import androidx.recyclerview.widget.DiffUtil
import com.android254.droidconKE2020.core.models.SpeakerUIModel

class SpeakerDiffUtilsCallback : DiffUtil.ItemCallback<SpeakerUIModel>() {
    override fun areItemsTheSame(oldItem: SpeakerUIModel, newItem: SpeakerUIModel): Boolean =
        oldItem.speakerName == newItem.speakerName && oldItem.speakerBio == newItem.speakerBio && oldItem.speakerAvatar == newItem.speakerAvatar

    override fun areContentsTheSame(oldItem: SpeakerUIModel, newItem: SpeakerUIModel): Boolean =
        oldItem == newItem
}