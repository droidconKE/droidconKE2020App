package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AccessToken(
    @Expose @SerializedName("token") val token: String,
    @Expose @SerializedName("user") val user: UserDetails
)

data class UserDetails(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("email") val email: String,
    @Expose @SerializedName("gender") val gender: String,
    @Expose @SerializedName("avatar") val avatar: String
)