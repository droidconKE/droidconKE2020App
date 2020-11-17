package com.android254.droidconKE2020.auth.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.core.utils.SingleLiveEvent

class AuthViewModel(sharedPref: Preferences) : ViewModel() {

    val isSignedIn = MutableLiveData(sharedPref.isSignedIn())
    val isLoading = MutableLiveData(false)
    val startSignInProcess = SingleLiveEvent<Int>()

    fun initiateSignIn(view: View) {
        isLoading.value = true
        startSignInProcess.value = 1
    }

    fun signIn(token: String?) {
        println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        println("Sending to backend...")
        println(token)
    }
}