package com.android254.droidconKE2020.core.utils

import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.formattedDate(): String? {
    var date: Date? = null
    var formattedDate: String? = null
    try {
        date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(this)
    } catch (e: ParseException) {
        null
    }
    date?.let {
        formattedDate = DateUtils.getRelativeTimeSpanString(it.time, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS)
            .toString()
    }
    return formattedDate
}