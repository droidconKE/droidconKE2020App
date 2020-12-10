package com.android254.droidconKE2020.core.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrganizerUIModel(
    val organizerName: String,
    val organizerAvatar: String,
    val organizerTagLine: String,
    val organizerBio: String,
    val organizerDesignation: String,
    val organizerTwitterHandle: String,
    val organizerType: String
) : Parcelable