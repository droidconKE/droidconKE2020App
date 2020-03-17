package com.android254.droidconKE2020.data.di

import androidx.room.Room
import com.android254.droidconKE2020.data.DroidConDB
import com.android254.droidconKE2020.data.user.LocalUserDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * 16/03/20
 * @author bernard
 */
val databaseModule = module {
    factory { LocalUserDataSource(get()) }

    factory { get<DroidConDB>().exampleDao() }

    single {
        Room.databaseBuilder(
                androidApplication(),
                DroidConDB::class.java,
                "droidCon.db")
            .build()
    }
}
