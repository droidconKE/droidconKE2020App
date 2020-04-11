package com.android254.droidconKE2020.speakers.models

data class Speaker(
    val id: Int,
    val name: String,
    val bio: String,
    val work: String,
    val company: String,
    val skills: List<String>,
    val imageUrl: String,
    val stars: List<Int>,
    val socialMedia: SocialMedia,
    val isKeynoteSpeaker: Boolean = false
)

data class SocialMedia(
    val twitter: String? = null
)