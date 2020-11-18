package com.android254.droidconKE2020.auth.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(sharedPref: Preferences, private val userRepository: UserRepository) :
    ViewModel() {

    val isSignedIn = MutableLiveData(sharedPref.isSignedIn())
    val isLoading = MutableLiveData(false)
    val startSignInProcess = SingleLiveEvent<Int>()
    val closeDialog = SingleLiveEvent<Int>()
    val showToast = SingleLiveEvent<String>()

    fun initiateSignIn(view: View) {
        isLoading.value = true
        startSignInProcess.value = 1
    }

    fun signOut(view: View) {
        isLoading.value = true
        viewModelScope.launch {
            val data = userRepository.logout()
            isLoading.value = false
            when (data) {
                is Data.Success -> {
                    closeDialog.value = 1
                    showToast.value = "Success"
                }
                is Data.Error -> {
                    showToast.value = "Logout failed"
                }
            }
        }
    }

    fun signIn(token: String?) {
        token?.let {
            viewModelScope.launch {
                val data = userRepository.login(it)
                isLoading.value = false
                when (data) {
                    is Data.Success -> {
                        closeDialog.value = 1
                        showToast.value = "Success"
                    }
                    is Data.Error -> {
                        showToast.value = "Login failed"
                    }
                }
            }
        }
    }
}