package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sponsors(
    @Expose @SerializedName("data") val data: List<SponsorResponse>
)

data class SponsorResponse(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("tagline") val tagLine: String,
    @Expose @SerializedName("link") val link: String,
    @Expose @SerializedName("logo") val logo: String,
    @Expose @SerializedName("created_at") val createdAt: String
)