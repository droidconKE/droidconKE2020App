package com.android254.droidconKE2020.home.domain

data class Sponsor(
    val id: Int,
    val imageUrl: String,
    val website: String,
    val isGold: Boolean = false
)