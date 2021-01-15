package com.android254.droidconKE2020.repository

sealed class Data<out T : Any> {
    data class Success<out T : Any>(val data: T) : Data<T>()
    data class Error(val exception: String?) : Data<Nothing>()
}

object Ok