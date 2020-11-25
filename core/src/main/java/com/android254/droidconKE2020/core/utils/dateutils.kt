package com.android254.droidconKE2020.core.utils

import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(): Date? {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault())
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}
fun Long.formattedDate() : String {
    return DateUtils.getRelativeTimeSpanString(this,System.currentTimeMillis(),DateUtils.SECOND_IN_MILLIS)
        .toString()
}