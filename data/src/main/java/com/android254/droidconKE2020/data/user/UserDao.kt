package com.android254.droidconKE2020.data.user

import androidx.room.Dao
import androidx.room.Query
import com.android254.droidconKE2020.data.user.model.User

/**
 * 15/03/20
 * @author bernard
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getUser(): User
}