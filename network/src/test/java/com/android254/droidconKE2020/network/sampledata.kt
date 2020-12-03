package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.responses.FeedItem
import com.android254.droidconKE2020.network.responses.SessionItem

val sampleFeed = listOf(
    FeedItem(
        title = "Test",
        topic = "droidconweb",
        body = "Good one",
        createdAt = "2020-03-19 18:45:49",
        image = "http://localhost:8000/upload/event/feeds/dangyntvmaet8jgjpg.jpg",
        url = "https://droidcon.co.ke"
    )
)

val sampleSession =
    SessionItem(
        "#7F9337",
        "#7F9337",
        "Dependency Injection via frameworks like Dagger were present in most modern Android projects.\n" +
            "But then Kotlin happened. And since then a bunch of new libraries like Koin or Kodein appeared. Developers are even writing articles how to do DI without any framework.\n" +
            "Some argue that those don’t even offer real dependency injection. Let’s look at that argument and compare the approaches.\n" +
            "So, is there something wrong with Dagger & co. in Kotlin? Are they obsolete? What are the alternatives? Let’s dive in.",
        "2021-05-06 08:45:00",
        "08:45:00",
        1,
        false,
        0,
        emptyList(),
        "Regular Session",
        "",
        "Intermediate",
        "to-inject-or-not-inject-dependency-injection-in-a-kotlin-world-1605037969",
        emptyList(),
        "2021-05-06 08:00:00",
        "08:00:00",
        "To Inject or not inject - Dependency injection in a Kotlin world",
    )