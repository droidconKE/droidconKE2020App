package com.android254.droidconKE2020.core.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SponsorUIModel(
    val name: String,
    val tagLine: String,
    val link: String,
    val logo: String
) : Parcelable