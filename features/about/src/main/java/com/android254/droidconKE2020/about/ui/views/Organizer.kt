package com.android254.droidconKE2020.about.ui.views

import androidx.annotation.DrawableRes
import com.android254.droidconKE2020.about.R

data class Organizer(
    val organizerId: Int,
    val name: String,
    @DrawableRes
    val imageUrl: Int = R.drawable.franktamre, // TODO Change to String type (image url)
    val title: String
)