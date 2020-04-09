package com.android254.droidconKE2020.speakers.models

data class SpeakerDetailsModel (
    val speakerName : String,
    val twitterHandle : String,
    val speakerCompany : String,
    val speakerRole : String,
    val speakerBio : String,
    val speakerProfileImg : String
)
data class Speaker(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val isKeynoteSpeaker: Boolean = false
)