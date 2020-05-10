package com.android254.droidconKE2020.home.domain

data class Speaker(
    val id: Int = 0,
    val name: String,
    val bio: String = "",
    val work: String = "",
    val company: String = "",
    val skills: List<String> = listOf(),
    val imageUrl: String = "",
    val stars: List<Int> = listOf(),
    val socialMedia: SocialMedia = SocialMedia(""),
    val isKeynoteSpeaker: Boolean = false
)

data class SocialMedia(
    val twitter: String? = null
)