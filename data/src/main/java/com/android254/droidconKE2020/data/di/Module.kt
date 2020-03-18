package com.android254.droidconKE2020.data.di

import androidx.room.Room
import com.android254.droidconKE2020.data.DroidConDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * 16/03/20
 * @author bernard
 */
val databaseModule = module {

    single {
        Room.databaseBuilder(
                androidApplication(),
                DroidConDB::class.java,
                "droidCon.db")
            .build()
    }
}
