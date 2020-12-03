package com.android254.droidconKE2020.repository.mappers

import com.android254.droidconKE2020.core.models.*
import com.android254.droidconKE2020.core.utils.formattedDate
import com.android254.droidconKE2020.core.utils.sessionStartTimeSuffix
import com.android254.droidconKE2020.core.utils.toDate
import com.android254.droidconKE2020.network.responses.FeedItem
import com.android254.droidconKE2020.network.responses.SessionItem
import com.android254.droidconKE2020.network.responses.Speaker

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
    sessionStartTimeSuffix = this.startDateTime.toDate().sessionStartTimeSuffix()

)

fun Speaker.toSpeakerUIModel(): SpeakerUIModel =
    SpeakerUIModel(
        speakerAvatar = this.avatar,
        speakerBio = this.biography,
        speakerTwitterProfile = this.twitter,
        speakerTagLine = this.tagline,
        speakerCompany = this.companyWebsite ?: "No Company",
        speakerName = this.name
    )