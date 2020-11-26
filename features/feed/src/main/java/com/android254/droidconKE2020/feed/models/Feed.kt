package com.android254.droidconKE2020.feed.models

import com.android254.droidconKE2020.feed.R

data class Feed(
    val content: String,
    val imageUrl: Int = R.drawable.dummy, // TODO Change to String type (image url)
    val time: String
)