package com.android254.droidconKE2020.network.di

import com.android254.droidconKE2020.network.URL.Companion.baseUrl
import com.android254.droidconKE2020.network.user.UserAPIService
import com.android254.droidconKE2020.network.user.RemoteUserDataSource
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.lang.reflect.Modifier

/**
 * 16/03/20
 * @author bernard
 */
val networkModule = module {
    factory { RemoteUserDataSource(get()) }

    factory { get<Retrofit>().create(UserAPIService::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(get())
            .build()
    }

    single {
        GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.PRIVATE)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}
