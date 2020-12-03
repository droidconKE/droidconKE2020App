package com.android254.droidconKE2020.sessions.utils

import com.android254.droidconKE2020.sessions.models.DaySession

// TODO use date conversions for response from API
fun getScheduleDays(): List<DaySession> = listOf(
    DaySession("06", "Day 1"),
    DaySession("07", "Day 2"),
    DaySession("08", "Day 3"),
)