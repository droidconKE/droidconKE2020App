package com.android254.droidconKE2020.sessions

import com.android254.droidconKE2020.sessions.ui.views.viewmodel.BookmarkedSessionsViewModel
import io.mockk.impl.annotations.InjectMockKs
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test

class BookmarkedSessionsViewModelTest: BaseViewModelTest() {
    @InjectMockKs
    lateinit var bookmarkedSessionsViewModel: BookmarkedSessionsViewModel

    @Test
    fun `test whether isNavigateBack live data is true when back navigation button is clicked`() {
        bookmarkedSessionsViewModel.onNavigateBack()
        Assert.assertTrue(bookmarkedSessionsViewModel.isNavigateBack.getOrAwaitValue())
    }

    @Test
    fun `test whether isNavigateBack live data is null when back navigation  has occurred`() {
        bookmarkedSessionsViewModel.onNavigatedBack()
        Assert.assertNull(bookmarkedSessionsViewModel.isNavigateBack.getOrAwaitValue())
    }

    @Test
    fun `test whether navigateToSessionDetail live data contains a session id when a session is clicked`() {
        bookmarkedSessionsViewModel.onSessionItemClicked(1L)
        MatcherAssert.assertThat(
            bookmarkedSessionsViewModel.navigateToSessionDetail.getOrAwaitValue(),
            CoreMatchers.`is`(1L)
        )
    }
    @Test
    fun `test whether navigateToSessionDetail live data is unset after navigation to session detail occurs`() {
        bookmarkedSessionsViewModel.onSessionDetailNavigated()
        MatcherAssert.assertThat(
            bookmarkedSessionsViewModel.navigateToSessionDetail.getOrAwaitValue(),
            CoreMatchers.`is`(0L)
        )
    }
}