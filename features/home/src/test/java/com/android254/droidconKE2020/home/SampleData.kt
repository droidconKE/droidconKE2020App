package com.android254.droidconKE2020.home

import com.android254.droidconKE2020.core.models.OrganizerUIModel
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.core.models.SponsorUIModel

val testSessions = listOf(
    SessionUIModel(
        "08:45 AM - 09:45 AM",
        "Room A",
        "",
        "08:45:00",
        "Dependency Injection via frameworks like Dagger were present in most modern Android projects.\n" +
                "But then Kotlin happened. And since then a bunch of new libraries like Koin or Kodein appeared. Developers are even writing articles how to do DI without any framework.\n" +
                "Some argue that those don’t even offer real dependency injection. Let’s look at that argument and compare the approaches.\n" +
                "So, is there something wrong with Dagger & co. in Kotlin? Are they obsolete? What are the alternatives? Let’s dive in.",
        false,
        emptyList(),
        0,
        "Dependency_injection",
        "",
        "08:45 AM",
        "AM",
        "Regular Session",
        false

    )
)

val testSponsors = listOf(
    SponsorUIModel(
        "Google",
        "Google is Google",
        "google.com",
        "https://api.droidcon.co.ke/upload/org_team/apppng.png"
    )
)

val testOrganisers = listOf(
    OrganizerUIModel(
        "John Doe",
        "https://api.droidcon.co.ke/upload/org_team/apppng.png",
        "Designer @ TheDesin",
        "Android Developer",
        "Android Developer",
        "wangerekaharun",
        "Individual"

    )
)

val testSpeakers = listOf(
    SpeakerUIModel(
        "https://api.droidcon.co.ke/upload/org_team/apppng.png",
        "My Bio",
        "@coolperson",
        "Wozzap!",
        "Some Company",
        "John Doe"
    )
)