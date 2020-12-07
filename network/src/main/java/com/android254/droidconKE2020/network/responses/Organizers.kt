package com.android254.droidconKE2020.network.responses


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Organizers(
    @Expose @SerializedName("data") val organizers: List<OrganizerItem>
)

data class OrganizerItem(
    @Expose @SerializedName("created_at") val createdAt: String,
    @Expose @SerializedName("link") val link: String,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("photo") val photo: String,
    @Expose @SerializedName("tagline") val tagline: String,
    @Expose @SerializedName("type") val type: String
)