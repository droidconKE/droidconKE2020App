package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.SerializedName

data class Feed (
  @SerializedName("data")
  val feedItems: List<FeedItem>,
  @SerializedName("meta")
  val meta: Meta
)

data class FeedItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("topic")
    val topic: String,
    @SerializedName("url")
    val url: String
)

data class Meta(
    @SerializedName("paginator")
    val paginator: Paginator
)

data class Paginator(
    @SerializedName("count")
    val count: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("has_more_pages")
    val hasMorePages: Boolean,
    @SerializedName("next_page")
    val nextPage: Int,
    @SerializedName("next_page_url")
    val nextPageUrl: String,
    @SerializedName("per_page")
    val perPage: String,
    @SerializedName("previous_page_url")
    val previousPageUrl: String
)