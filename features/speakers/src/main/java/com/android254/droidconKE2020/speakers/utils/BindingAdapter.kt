package com.android254.droidconKE2020.speakers.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.android254.droidconKE2020.speaker.R

@BindingAdapter("droidconLogoImageResource")
fun droidconLogoImageResource(imageView: ImageView, isSearchViewEmpty: Boolean) {
    val imgResource =
        if (isSearchViewEmpty) com.android254.droidconKE2020.R.drawable.ic_droidcon_logo
        else R.drawable.ic_clear_24px

    imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context,imgResource))
}
