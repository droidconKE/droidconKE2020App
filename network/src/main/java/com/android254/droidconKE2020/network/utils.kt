package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.core.Preferences
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AuthInterceptor(private val sharedPref: Preferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val origRequest = chain.request()
        val accessToken = sharedPref.getAccessToken()
        val builder = origRequest.newBuilder()

        builder.addHeader("Content-Type", "application/json")
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Api-Authorization-Key", BuildConfig.API_KEY)

        if (accessToken.isNotEmpty()) {
            builder.addHeader("Authorization", "Bearer $accessToken")
        }

        val newRequest = builder.build()

        return chain.proceed(newRequest)
    }
}

/** @see Call.await */
internal class ContinuationCallback(
    private val call: Call,
    private val continuation: CancellableContinuation<Response>
) : Callback, CompletionHandler {

    override fun onResponse(call: Call, response: Response) {
        continuation.resume(response)
    }

    override fun onFailure(call: Call, e: IOException) {
        if (!call.isCanceled()) {
            continuation.resumeWithException(e)
        }
    }

    override fun invoke(cause: Throwable?) {
        try {
            call.cancel()
        } catch (_: Throwable) {
        }
    }
}

internal suspend inline fun Call.await(): Response {
    return suspendCancellableCoroutine { continuation ->
        val callback = ContinuationCallback(this, continuation)
        enqueue(callback)
        continuation.invokeOnCancellation(callback)
    }
}