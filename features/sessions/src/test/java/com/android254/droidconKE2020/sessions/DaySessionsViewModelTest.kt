package com.android254.droidconKE2020.sessions

import com.android254.droidconKE2020.sessions.ui.views.viewmodel.DaySessionsViewModel
import io.mockk.impl.annotations.InjectMockKs
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNull
import org.junit.Test

class DaySessionsViewModelTest : BaseViewModelTest() {

    @InjectMockKs
    lateinit var daySessionsViewModel: DaySessionsViewModel

    @Test
    fun `test that day sessions live data is not empty when getDaySessions() is called`() {
        daySessionsViewModel.getDaySessions("Day 1")
        assertThat(
            daySessionsViewModel.daySessions.getOrAwaitValue().isNotEmpty(),
            `is`(true)
        )
    }

    @Test
    fun `test whether navigateToSessionDetail live data contains a session id when a session is clicked`() {
        daySessionsViewModel.onSessionItemClicked(1L)
        assertThat(
            daySessionsViewModel.navigateToSessionDetail.getOrAwaitValue(),
            `is`(1L)
        )
    }

//    @Test
    fun `test whether navigateToSessionDetail live data is null after navigation to session detail occurs`() {
        daySessionsViewModel.onSessionDetailNavigated()
        assertNull(daySessionsViewModel.navigateToSessionDetail.getOrAwaitValue())
    }

    @Test
    fun `test whether saveSessionItem live data contains a session when a session is saved`() {
        daySessionsViewModel.onSaveSessionItemClicked(session = testSession)
        assertThat(
            daySessionsViewModel.saveSessionItem.getOrAwaitValue(),
            `is`(testSession)
        )
    }

    //    @Test
    fun `test whether saveSessionItem live data is null when a session has been saved`() {
        daySessionsViewModel.onSessionItemSaved()
        assertNull(daySessionsViewModel.saveSessionItem.getOrAwaitValue())
    }
}