package com.android254.droidconKE2020.network.user

/**
 * 15/03/20
 * @author bernard
 */
class RemoteUserDataSource(private val userAPIService: UserAPIService) {

    fun login(username: String, password: String) {
        userAPIService.login(username, password)
    }
}
