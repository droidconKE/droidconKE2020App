package com.android254.droidconKE2020.feedback

import com.android254.droidconKE2020.feedback.ui.viewmodels.EventFeedbackViewModel
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.feedback.EventFeedbackRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class EventFeedbackViewModelTest : BaseViewModelTest() {
    private val eventFeedbackRepository = mockk<EventFeedbackRepository>()
    lateinit var eventFeedbackViewModel: EventFeedbackViewModel

    @Before
    fun setup() {
        eventFeedbackViewModel = EventFeedbackViewModel(eventFeedbackRepository)
    }

    @Test
    fun `test event feedback is submitted successfully`() {
        coEvery { eventFeedbackRepository.sendEventFeedback("Awesome", 5) } returns Data.Success("Feedback sent successfully, Thank you")
        eventFeedbackViewModel.sendEventFeedback("Awesome", 5)
        coVerify { eventFeedbackViewModel.sendEventFeedback("Awesome", 5) }
        eventFeedbackViewModel.submitFeedback.test().assertValue(Data.Success("Feedback sent successfully, Thank you"))
    }
}