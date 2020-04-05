package com.android254.droidconKE2020

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar

class CustomToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0) : Toolbar(context, attrs,defStyle) {



    init {
        View.inflate(context,R.layout.home_signed_out_toolbar,null)

    }

    interface ChangeLayoutListener{
        fun onDestinationChanged(destinationName : String)
    }
}