package com.android254.droidconKE2020.network.user

import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 15/03/20
 * @author bernard
 */
interface UserAPIService {
    @POST("/login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    )
}