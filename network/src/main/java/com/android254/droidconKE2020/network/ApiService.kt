package com.android254.droidconKE2020.network

import retrofit2.Retrofit

class ApiService(retrofit: Retrofit) {
    val events = retrofit.create(EventEndpoints::class.java)
    val auth = retrofit.create(AuthEndpoints::class.java)
    val feed = retrofit.create(FeedEndpoints::class.java)
}