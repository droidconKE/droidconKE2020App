package com.android254.droidconKE2020.home.domain

data class Speaker(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val isKeynoteSpeaker: Boolean = false
)