package com.android254.droidconKE2020.auth.viewModels

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.android254.droidconKE2020.auth.R
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.tasks.await

interface AuthFlow {
    suspend fun getSignInIntent(): PendingIntent

    fun getToken(data: Intent): String?
}

class GoogleAuthFlow(private val context: Context) : AuthFlow {

    private val signInClient = Identity.getSignInClient(context)

    override suspend fun getSignInIntent(): PendingIntent {
        val request = GetSignInIntentRequest.builder()
            .setServerClientId(context.getString(R.string.server_client_id))
            .build()
        return signInClient.getSignInIntent(request).await()
    }

    override fun getToken(data: Intent): String? {
        val credential = signInClient.getSignInCredentialFromIntent(data)
        return credential.googleIdToken
    }

}