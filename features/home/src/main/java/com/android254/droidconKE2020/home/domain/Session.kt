package com.android254.droidconKE2020.home.domain

data class Session(
    val id: Long,
    val title: String,
    val description: String,
    val time: String,
    val room: String,
    val imageUrl: String,
    val speaker: Speaker
)