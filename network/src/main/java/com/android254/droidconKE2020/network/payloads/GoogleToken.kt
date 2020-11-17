package com.android254.droidconKE2020.network.payloads

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GoogleToken(@Expose @SerializedName("access_token") val token: String)