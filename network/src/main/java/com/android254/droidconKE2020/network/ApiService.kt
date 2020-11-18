package com.android254.droidconKE2020.network

import retrofit2.Retrofit

class ApiService(refrofit: Retrofit) {
    val events = refrofit.create(EventEndpoints::class.java)
    val auth = refrofit.create(AuthEndpoints::class.java)
}