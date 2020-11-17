package com.android254.droidconKE2020.auth.viewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import com.android254.droidconKE2020.auth.R
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.UserRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.tasks.await

interface AuthFlow {
    fun getSignInIntent(): Intent

    suspend fun getToken(data: Intent): String?
}

class GoogleAuthFlow(private val context: Context, private val userRepository: UserRepository) :
    AuthFlow {

    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(context.getString(R.string.server_client_id))
        .requestServerAuthCode(context.getString(R.string.server_client_id))
        .requestEmail()
        .build()
    private val signInClient = GoogleSignIn.getClient(context, gso)

    override fun getSignInIntent(): Intent {
        return signInClient.signInIntent
    }

    override suspend fun getToken(data: Intent): String? {
        return try {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.await()
            val authCode = account.serverAuthCode
            getAccessToken(authCode!!)
        } catch (e: ApiException) {
            Log.w(TAG, "signInResult:failed code=${e.statusCode}")
            null
        }
    }

    private suspend fun getAccessToken(authCode: String): String? {
        val clientId = context.getString(R.string.server_client_id)
        val clientSecret = context.getString(R.string.server_client_secret)
        val data = userRepository.getAccessTokenFromGoogle(clientId, clientSecret, authCode)
        return when (data) {
            is Data.Success -> {
                data.data
            }
            is Data.Error -> {
                Log.w(TAG, data.exception)
                null
            }
        }
    }

    companion object {
        private const val TAG = "GoogleAuthFlow"
    }
}