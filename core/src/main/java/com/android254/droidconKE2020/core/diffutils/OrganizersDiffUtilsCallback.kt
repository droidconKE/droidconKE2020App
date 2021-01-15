package com.android254.droidconKE2020.core.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.android254.droidconKE2020.core.models.OrganizerUIModel

class OrganizersDiffUtilsCallback : DiffUtil.ItemCallback<OrganizerUIModel>() {
    override fun areItemsTheSame(oldItem: OrganizerUIModel, newItem: OrganizerUIModel): Boolean {
        return oldItem.organizerName == newItem.organizerName && oldItem.organizerAvatar == newItem.organizerAvatar
    }

    override fun areContentsTheSame(oldItem: OrganizerUIModel, newItem: OrganizerUIModel): Boolean {
        return oldItem == newItem
    }
}