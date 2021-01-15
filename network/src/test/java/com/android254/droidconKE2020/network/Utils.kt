package com.android254.droidconKE2020.network

import com.google.common.io.Resources
import java.io.File

fun getJson(path: String): String {
    val uri = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}