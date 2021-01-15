package com.android254.droidconKE2020.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Message(@Expose @SerializedName("message") val message: String)