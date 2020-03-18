package com.android254.droidconKE2020.auth

import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.repository.user.UserRepository

/**
 * 17/03/20
 * @author bernard
 */
class AuthViewModel(private val repository: UserRepository): ViewModel() {
    fun login(username: String, password: String) {
        repository.login(username, password)
    }
}