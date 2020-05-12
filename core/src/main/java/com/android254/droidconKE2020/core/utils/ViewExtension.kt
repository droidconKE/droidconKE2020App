package com.android254.droidconKE2020.core.utils

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

/**
 * 12/04/20
 */
fun View.getParentActivity(): Activity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    return null
}