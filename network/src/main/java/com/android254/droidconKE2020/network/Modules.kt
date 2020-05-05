package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.di.Constants.BASE_URL
import com.google.gson.GsonBuilder
import java.lang.reflect.Modifier
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * 16/03/20
 * @author bernard
 */
val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
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
