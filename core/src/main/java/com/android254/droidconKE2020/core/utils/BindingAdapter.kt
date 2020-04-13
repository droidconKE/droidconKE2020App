package com.android254.droidconKE2020.core.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView
import coil.api.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImage(imageView : ShapedImageView,imageUrl : String){
    imageView.load(imageUrl) {
        transformations(RoundedCornersTransformation(12f))
    }
}

@BindingAdapter("mutableText")
fun mutableText(view: TextView, text: String) {
    view.text = text
}

@BindingAdapter("imageSrc")
fun imageSrc(view: ImageView, src: Int) {
    view.setImageResource(src)
}