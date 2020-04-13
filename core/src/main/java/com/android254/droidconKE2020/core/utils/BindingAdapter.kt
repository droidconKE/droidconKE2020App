package com.android254.droidconKE2020.core.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView
import coil.api.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImage(imageView : ShapedImageView,imageUrl : String){
    imageView.load(imageUrl) {
        transformations(RoundedCornersTransformation(12f))
    }
}

@BindingAdapter("text")
fun loadText(view: TextView, text: String?) {
    view.text = text?:""
}

@BindingAdapter("imageSrc")
fun loadImage(view: ImageView, src: Int) {
    view.setImageResource(src)
}