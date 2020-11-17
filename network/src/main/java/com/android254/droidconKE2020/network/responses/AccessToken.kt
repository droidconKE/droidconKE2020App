package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AccessToken(
    @Expose @SerializedName("type") val type: String,
    @Expose @SerializedName("bearer") val bearer: Bearer
)

data class Bearer(
    @Expose @SerializedName("token") val token: String
)