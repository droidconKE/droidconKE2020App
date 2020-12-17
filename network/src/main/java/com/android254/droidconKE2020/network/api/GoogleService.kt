package com.android254.droidconKE2020.network.api

import com.android254.droidconKE2020.network.BuildConfig
import com.android254.droidconKE2020.network.utils.await
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject

class GoogleService {

    suspend fun getAccessToken(clientId: String, clientSecret: String, authCode: String): String {
        val logger = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BODY
            }
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        val requestBody = FormBody.Builder()
            .add("grant_type", "authorization_code")
            .add("client_id", clientId)
            .add("clientSecret", clientSecret)
            .add("redirect_uri", "")
            .add("code", authCode)
            .build()

        val request = Request.Builder()
            .url("https://www.googleapis.com/oauth2/v4/token")
            .post(requestBody)
            .build()

        val response = client.newCall(request).await()
        val jsonObject = JSONObject(response.body!!.string())
        return jsonObject.getString("access_token")
    }
}