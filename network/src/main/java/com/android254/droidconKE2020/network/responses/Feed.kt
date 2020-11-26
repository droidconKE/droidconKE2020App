package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Feed(
    @Expose @SerializedName("data") val feedItems: List<FeedItem>,
    @Expose @SerializedName("meta") val meta: Meta
)

data class FeedItem(
    @Expose @SerializedName("body") val body: String,
    @Expose @SerializedName("created_at") val createdAt: String,
    @Expose @SerializedName("image") val image: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("topic") val topic: String,
    @Expose @SerializedName("url") val url: String
)

data class Meta(
    @Expose @SerializedName("paginator") val paginator: Paginator
)

data class Paginator(
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("current_page") val currentPage: Int,
    @Expose @SerializedName("has_more_pages") val hasMorePages: Boolean,
    @Expose @SerializedName("next_page") val nextPage: Int,
    @Expose @SerializedName("next_page_url") val nextPageUrl: String,
    @Expose @SerializedName("per_page") val perPage: String,
    @Expose @SerializedName("previous_page_url") val previousPageUrl: String
)