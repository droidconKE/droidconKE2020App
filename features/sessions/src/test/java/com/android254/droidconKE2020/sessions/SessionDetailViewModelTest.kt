package com.android254.droidconKE2020.sessions

import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionDetailViewModel
import io.mockk.impl.annotations.InjectMockKs
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class SessionDetailViewModelTest : BaseViewModelTest() {

    @InjectMockKs
    lateinit var sessionDetailViewModel: SessionDetailViewModel

    @Test
    fun `test whether session details live data contains a session when getSessionDetails() is called`() {
        sessionDetailViewModel.getSessionDetails(1L)
        assertNotNull(sessionDetailViewModel.sessionDetails.getOrAwaitValue())
    }

    @Test
    fun `test whether save session live data contains a session when a user saves a session`() {
        sessionDetailViewModel.onClickSaveSession(testSessionDetail)
        assertThat(
            sessionDetailViewModel.saveSession.getOrAwaitValue().sessionTitle,
            `is`(
                testSessionDetail.sessionTitle
            )
        )
    }

    @Test
    fun `test whether share session contains a session when user shares a session`() {
        sessionDetailViewModel.onClickShareSession(testSessionDetail)
        assertThat(
            sessionDetailViewModel.shareSession.getOrAwaitValue().sessionTitle,
            `is`(
                testSessionDetail.sessionTitle
            )
        )
    }


    @Test
    fun `test whether click speaker live data contains a speaker id when a user clicks a speaker name`() {
        sessionDetailViewModel.onClickSpeaker(1001)
        assertThat(sessionDetailViewModel.clickSpeaker.getOrAwaitValue(), `is`(1001))
    }

    @Test
    fun `test whether navigate back live data value is true when user clicks navigate back arrow`() {
        sessionDetailViewModel.onNavigateBack()
        assertThat(sessionDetailViewModel.navigateBack.getOrAwaitValue(), `is`(true))
    }

    @Test
    fun `test navigate back live data is set to false after user has navigated back`() {
        sessionDetailViewModel.onNavigatedBack()
        assertThat(sessionDetailViewModel.navigateBack.getOrAwaitValue(),`is`(false))
    }
}