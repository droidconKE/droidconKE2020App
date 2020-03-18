package com.android254.droidconKE2020.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android254.droidconKE2020.data.user.model.User
import com.android254.droidconKE2020.data.user.UserDao

/**
 * 15/03/20
 * @author bernard
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DroidConDB: RoomDatabase() {
    abstract fun userDao(): UserDao
}