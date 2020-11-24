package com.android254.droidconKE2020.repository.mappers

import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.network.responses.FeedItem

fun List<FeedItem>.toFeedUIModels() : List<FeedUIModel>{
    val feeds = mutableListOf<FeedUIModel>()
    this.forEach {feedItem ->
        feeds.add(
            FeedUIModel(
            content = feedItem.body,
                imageUrl = feedItem.image,
                time = feedItem.createdAt
        ))
    }
    return feeds
}