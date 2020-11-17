package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.payloads.GoogleToken
import com.android254.droidconKE2020.network.responses.AccessToken
import com.android254.droidconKE2020.network.responses.Message
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthEndpoints {

    @POST("social_login/google")
    suspend fun googleLogin(@Body token: GoogleToken): AccessToken

    @POST("logout")
    suspend fun logout(): Message
}