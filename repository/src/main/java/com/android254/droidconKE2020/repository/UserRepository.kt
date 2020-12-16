package com.android254.droidconKE2020.repository

import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.network.api.GoogleService
import com.android254.droidconKE2020.network.payloads.GoogleToken
import retrofit2.HttpException
import java.io.IOException

interface UserRepository {
    suspend fun login(token: String): Data<Ok>

    suspend fun getAccessTokenFromGoogle(
        clientId: String,
        clientSecret: String,
        authCode: String
    ): Data<String>

    suspend fun logout(): Data<Ok>
}

class UserRepositoryImpl(
    apiService: ApiService,
    private val googleService: GoogleService,
    private val sharedPref: Preferences
) : UserRepository {
    private val auth = apiService.auth

    override suspend fun login(token: String): Data<Ok> {
        return try {
            val resToken = auth.googleLogin(GoogleToken(token))
            sharedPref.setAccessToken(resToken.token)
            // Todo Save user details
            sharedPref.setSignedIn(true)
            Data.Success(Ok)
        } catch (e: HttpException) {
            Data.Error(e.message)
        }
    }

    override suspend fun getAccessTokenFromGoogle(
        clientId: String,
        clientSecret: String,
        authCode: String
    ): Data<String> {
        return try {
            val token = googleService.getAccessToken(clientId, clientSecret, authCode)
            return Data.Success(token)
        } catch (e: IOException) {
            Data.Error(e.message)
        }
    }

    override suspend fun logout(): Data<Ok> {
        return try {
            auth.logout()
            sharedPref.setAccessToken("")
            sharedPref.setSignedIn(false)
            Data.Success(Ok)
        } catch (e: HttpException) {
            Data.Error(e.message)
        }
    }
}