package com.android254.droidconKE2020.home.utils

import androidx.recyclerview.widget.DiffUtil
import com.android254.droidconKE2020.core.models.SessionUIModel

class SessionsDiffUtilsCallback : DiffUtil.ItemCallback<SessionUIModel>() {
    override fun areItemsTheSame(oldItem: SessionUIModel, newItem: SessionUIModel): Boolean =
        oldItem.sessionSlug == newItem.sessionSlug

    override fun areContentsTheSame(oldItem: SessionUIModel, newItem: SessionUIModel): Boolean =
        oldItem == newItem
}