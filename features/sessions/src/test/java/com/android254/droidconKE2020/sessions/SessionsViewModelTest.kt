package com.android254.droidconKE2020.sessions

import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class SessionsViewModelTest : BaseViewModelTest() {
    private val sessionRepository = mockk<SessionRepository>()
    lateinit var sessionsViewModel: SessionsViewModel

    @Before
    fun setUp() {
        sessionsViewModel = SessionsViewModel(sessionRepository)
    }

    @Test
    fun `test that sessions are fetched`() = runBlockingTest {
        coEvery { sessionRepository.fetchSessionsSchedule("Day 1") } returns Data.Success(
            testSessions
        )
        sessionsViewModel.fetchSessions("Day 1")

        coVerify { sessionRepository.fetchSessionsSchedule("Day 1") }
        sessionsViewModel.sessions.test().assertValue(testSessions)
    }

    @Test
    fun `test that only bookmarked sessions are fetched`() = runBlockingTest {
        coEvery { sessionRepository.fetchSessionsSchedule("Day 1") } returns Data.Success(
            testSessions
        )
        sessionsViewModel.showBookmarked = true
        sessionsViewModel.fetchSessions("Day 1")

        coVerify { sessionRepository.fetchSessionsSchedule("Day 1") }
        sessionsViewModel.sessions.test().assertValue { it.size == 1 }
    }

    @Test
    fun `test session is set successfully`() {
        sessionsViewModel.setSession(testSessions[0])
        sessionsViewModel.sessionUIModel.test().assertValue(testSessions[0])
    }

    @Test
    fun `test show toast has value when error occurs`() {
        coEvery { sessionRepository.fetchSessionsSchedule("Day 1") } returns Data.Error(
            "Error Occurred"
        )
        runBlocking {
            sessionsViewModel.fetchSessions("Day 1")
        }
        coVerify { sessionRepository.fetchSessionsSchedule("Day 1") }
        sessionsViewModel.showToast.test().assertValue("Error Occurred")
    }

    @Test
    fun `test a session is bookmarked`() {
        coEvery { sessionRepository.changeBookmarkStatus(1) } returns Data.Success("Bookmarked")
        sessionsViewModel.changeBookmarkStatus(1)
        coVerify { sessionRepository.changeBookmarkStatus(1) }
        sessionsViewModel.isSessionBookmarked.test().assertValue("Bookmarked")
    }

    @Test
    fun `test a session is removed from bookmarks`() {
        coEvery { sessionRepository.changeBookmarkStatus(1) } returns Data.Success("Bookmark Removed")
        sessionsViewModel.changeBookmarkStatus(1)
        coVerify { sessionRepository.changeBookmarkStatus(1) }
        sessionsViewModel.isSessionBookmarked.test().assertValue("Bookmark Removed")
    }

}