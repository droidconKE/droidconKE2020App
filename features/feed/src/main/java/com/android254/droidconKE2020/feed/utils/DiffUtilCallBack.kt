package com.android254.droidconKE2020.feed.utils

import androidx.recyclerview.widget.DiffUtil
import com.android254.droidconKE2020.core.models.FeedUIModel

class DiffUtilCallBack : DiffUtil.ItemCallback<FeedUIModel>() {
    override fun areItemsTheSame(oldItem: FeedUIModel, newItem: FeedUIModel): Boolean {
        return oldItem.content == newItem.content
    }

    override fun areContentsTheSame(oldItem: FeedUIModel, newItem: FeedUIModel): Boolean {
       return oldItem == newItem
    }
}