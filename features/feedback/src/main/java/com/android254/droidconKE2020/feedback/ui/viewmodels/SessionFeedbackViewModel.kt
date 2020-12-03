package com.android254.droidconKE2020.feedback.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.feedback.SessionFeedbackRepository
import kotlinx.coroutines.launch

class SessionFeedbackViewModel(private val sessionFeedbackRepository: SessionFeedbackRepository) : ViewModel() {
    private var _sessionFeedback = MutableLiveData<String>()
    val sessionFeedback get() = _sessionFeedback
    val showToast = SingleLiveEvent<String>()


    fun submitSessionFeedback(sessionSlug: String, feedback: String, rating: Int){
        viewModelScope.launch {
            when(val value = sessionFeedbackRepository.submitSessionFeedback(sessionSlug, feedback, rating)){
                is Data.Success -> _sessionFeedback.postValue(value.data)
                is Data.Error -> showToast.postValue(value.exception.toString())
            }
        }
    }

}