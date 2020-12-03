package com.android254.droidconKE2020.feedback

import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.feedback.ui.viewmodels.SessionFeedbackViewModel
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.feedback.SessionFeedbackRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class SessionFeedbackViewModelTest : BaseViewModelTest() {
    private val sessionFeedbackRepository = mockk<SessionFeedbackRepository>()
    lateinit var sessionFeedbackViewModel: SessionFeedbackViewModel

    @Before
    fun setup (){
        sessionFeedbackViewModel = SessionFeedbackViewModel(sessionFeedbackRepository)
    }

    @Test
    fun `test session feedback is submitted successfully`(){
        coEvery { sessionFeedbackRepository.submitSessionFeedback("session_one","awesome", 4) } returns Data.Success("Feedback sent successfully, Thank you")
        sessionFeedbackViewModel.submitSessionFeedback("session_one","awesome", 4)
        coVerify { sessionFeedbackRepository.submitSessionFeedback("session_one","awesome", 4) }
        sessionFeedbackViewModel.sessionFeedback.test().assertValue("Feedback sent successfully, Thank you")
    }

    @Test
    fun `test show toast value is updated when error occurs`(){
        coEvery { sessionFeedbackRepository.submitSessionFeedback("session_one","awesome", 4) } returns Data.Error("An error occurred")
        sessionFeedbackViewModel.submitSessionFeedback("session_one","awesome", 4)
        coVerify { sessionFeedbackRepository.submitSessionFeedback("session_one","awesome", 4) }
        sessionFeedbackViewModel.showToast.test().assertValue("An error occurred")
    }
}