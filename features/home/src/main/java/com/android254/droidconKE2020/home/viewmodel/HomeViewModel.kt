package com.android254.droidconKE2020.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _testData = MutableLiveData<Int>()
    val testData get() = _testData

    fun incrementTestData() {
        val current = _testData.value ?: 0
        _testData.postValue(current + 1)
    }

}
