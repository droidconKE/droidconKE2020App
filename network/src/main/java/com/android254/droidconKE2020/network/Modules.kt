package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.di.Constants.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    single {
        BASE_URL.toHttpUrl()
    }

    single {
        val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
        val gsonFactory = GsonConverterFactory.create(gson)
        Retrofit.Builder()
            .baseUrl(get<HttpUrl>())
            .client(get())
            .addConverterFactory(gsonFactory)
            .build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single<Interceptor> {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    single {
        ApiService(get())
    }
}