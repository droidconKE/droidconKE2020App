package com.android254.droidconKE2020.core.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SessionUIModel(
    val sessionDuration: String,
    val sessionVenue: String,
    val sessionLevel: String,
    val sessionTitle: String,
    val sessionDescription: String,
    var isBookmarked: Boolean = false,
    val sessionSpeakers: List<SpeakerUIModel>,
    val sessionId: Int,
    val sessionSlug: String,
    val sessionImage: String,
    val sessionStartTime: String,
    val sessionStartTimeSuffix: String,
    val sessionFormat: String,
    val isKeynote: Boolean
) : Parcelable

@Parcelize
data class SpeakerUIModel(
    val speakerAvatar: String,
    val speakerBio: String,
    val speakerTwitterProfile: String,
    val speakerTagLine: String,
    val speakerCompany: String,
    val speakerName: String
) : Parcelable