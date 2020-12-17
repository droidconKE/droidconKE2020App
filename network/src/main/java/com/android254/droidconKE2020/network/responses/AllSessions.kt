package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllSessions(
    @Expose @SerializedName("data") val sessions: List<SessionItem>
)