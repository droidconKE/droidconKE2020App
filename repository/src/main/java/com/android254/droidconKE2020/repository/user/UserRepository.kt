package com.android254.droidconKE2020.repository.user

import com.android254.droidconKE2020.data.user.LocalUserDataSource
import com.android254.droidconKE2020.network.user.RemoteUserDataSource

/**
 * 16/03/20
 * @author bernard
 */
class UserRepository(
    private val localDataSource: LocalUserDataSource,
    private val remoteUserDataSource: RemoteUserDataSource
) {
    fun login(username: String, password: String) {

    }
}