package com.android254.droidconKE2020.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView
import coil.api.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImage(imageView: ShapedImageView, imageUrl: String?) {
    imageView.load(imageUrl) {
        transformations(RoundedCornersTransformation(12f))
    }
}

@BindingAdapter("rectImageUrl")
fun rectImageUrl(imageView: ShapedImageView, imageUrl: String?) {
    imageView.load(imageUrl)
}
