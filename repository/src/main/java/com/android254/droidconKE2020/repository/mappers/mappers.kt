package com.android254.droidconKE2020.repository.mappers

import com.android254.droidconKE2020.core.models.*
import com.android254.droidconKE2020.core.utils.formattedDate
import com.android254.droidconKE2020.core.utils.sessionStartTimeSuffix
import com.android254.droidconKE2020.core.utils.toDate
import com.android254.droidconKE2020.network.responses.*

fun FeedItem.toFeedUIModel(): FeedUIModel =
    FeedUIModel(
        content = this.body,
        imageUrl = this.image,
        time = this.createdAt.formattedDate().toString()
    )

fun SessionItem.toSessionUIModel(): SessionUIModel = SessionUIModel(
    sessionDuration = this.startDateTime.toDate() + " - " + this.endDateTime.toDate(),
    sessionVenue = this.rooms[0].title,
    sessionLevel = this.sessionLevel,
    sessionTitle = this.title,
    sessionDescription = this.description,
    isBookmarked = this.isBookmarked,
    sessionSpeakers = this.speakers.map { speaker ->
        speaker.toSpeakerUIModel()
    },
    sessionId = this.id,
    sessionSlug = this.slug,
    sessionImage = this.sessionImage ?: "",
    sessionStartTime = this.startDateTime.toDate(),
    sessionStartTimeSuffix = this.startDateTime.toDate().sessionStartTimeSuffix(),
    sessionFormat = this.sessionFormat,
    isKeynote = this.isKeynote
)

fun Speaker.toSpeakerUIModel(): SpeakerUIModel =
    SpeakerUIModel(
        speakerAvatar = this.avatar ?: "",
        speakerBio = this.biography ?: "No bio",
        speakerTwitterProfile = this.twitter ?: "",
        speakerTagLine = this.tagline ?: "",
        speakerCompany = this.companyWebsite ?: "No Company",
        speakerName = this.name
    )

fun OrganizerItem.toOrganizerUIModel(): OrganizerUIModel =
    OrganizerUIModel(
        organizerName = this.name,
        organizerAvatar = this.photo,
        organizerTagLine = this.tagline,
        organizerBio = this.bio,
        organizerDesignation = this.designation,
        organizerTwitterHandle = this.twitterHandle,
        organizerType = this.type
    )

fun SponsorItem.toSponsorUIModel(): SponsorUIModel =
    SponsorUIModel(
        name = this.name,
        tagLine = this.tagLine,
        link = this.link,
        logo = this.logo
    )