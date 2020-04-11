package com.android254.droidconKE2020.speakers.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("droidconLogoImageResource")
fun droidconLogoImageResource(imageView: ImageView, isSearchViewEmpty: Boolean) {
    val imgResource =
        if (isSearchViewEmpty) com.android254.droidconKE2020.R.drawable.ic_droidcon_logo
        else com.android254.droidconKE2020.R.drawable.ic_clear_24px

    imageView.load(imgResource)
}
