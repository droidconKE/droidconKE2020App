package com.android254.droidconKE2020.data.user

import com.android254.droidconKE2020.data.user.model.User

/**
 * 15/03/20
 * @author bernard
 */
class LocalUserDataSource(private val userDao: UserDao) {
    fun getExample(): User {
        return userDao.getUser()
    }
}