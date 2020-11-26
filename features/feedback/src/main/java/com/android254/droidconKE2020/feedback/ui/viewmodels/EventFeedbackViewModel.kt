package com.android254.droidconKE2020.feedback.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.feedback.EventFeedbackRepository
import kotlinx.coroutines.launch

class EventFeedbackViewModel(private val eventFeedbackRepository: EventFeedbackRepository) : ViewModel() {
    private var _submitFeedback = MutableLiveData<Data<String>>()
    val submitFeedback get() = _submitFeedback

    fun sendEventFeedback(feedback: String, rating: Int) {
        viewModelScope.launch {
            _submitFeedback.postValue(eventFeedbackRepository.sendEventFeedback(feedback, rating))
        }
    }
}