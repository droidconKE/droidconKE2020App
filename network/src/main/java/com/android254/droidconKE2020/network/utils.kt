package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.core.Preferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPref: Preferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val origRequest = chain.request()
        val accessToken = sharedPref.getAccessToken()
        val builder = origRequest.newBuilder()

        if (accessToken.isNotEmpty()) {
            builder.addHeader("Authorization", "Bearer $accessToken")
        }

        val newRequest = builder.build()

        return chain.proceed(newRequest)
    }

}