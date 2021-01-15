package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sessions(
    @Expose @SerializedName("data") val sessionDays: SessionDays
)

data class SessionDays(
    @Expose @SerializedName("2021-05-06") val dayOneSessions: List<SessionItem>,
    @Expose @SerializedName("2021-05-07") val dayTwoSessions: List<SessionItem>,
    @Expose @SerializedName("2021-05-08") val dayThreeSessions: List<SessionItem>
)

data class SessionItem(
    @Expose @SerializedName("backgroundColor") val backgroundColor: String,
    @Expose @SerializedName("borderColor") val borderColor: String,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("end_date_time") val endDateTime: String,
    @Expose @SerializedName("end_time") val endTime: String,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("is_bookmarked") val isBookmarked: Boolean,
    @Expose @SerializedName("is_serviceSession") val isServiceSession: Int,
    @Expose @SerializedName("is_keynote") val isKeynote: Boolean,
    @Expose @SerializedName("rooms") val rooms: List<Room>,
    @Expose @SerializedName("session_format") val sessionFormat: String,
    @Expose @SerializedName("session_image") val sessionImage: String?,
    @Expose @SerializedName("session_level") val sessionLevel: String,
    @Expose @SerializedName("slug") val slug: String,
    @Expose @SerializedName("speakers") val speakers: List<Speaker>,
    @Expose @SerializedName("start_date_time") val startDateTime: String,
    @Expose @SerializedName("start_time") val startTime: String,
    @Expose @SerializedName("title") val title: String
)

data class Room(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("title") val title: String
)

data class Speaker(
    @Expose @SerializedName("avatar") val avatar: String?,
    @Expose @SerializedName("biography") val biography: String?,
    @Expose @SerializedName("blog") val blog: String?,
    @Expose @SerializedName("company_website") val companyWebsite: String?,
    @Expose @SerializedName("facebook") val facebook: String?,
    @Expose @SerializedName("instagram") val instagram: String?,
    @Expose @SerializedName("linkedin") val linkedin: String?,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("tagline") val tagline: String?,
    @Expose @SerializedName("twitter") val twitter: String?
)