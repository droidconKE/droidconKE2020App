package com.android254.droidconKE2020.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * 15/03/20
 * @author bernard
 */
@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class DroidConDB: RoomDatabase() {
}