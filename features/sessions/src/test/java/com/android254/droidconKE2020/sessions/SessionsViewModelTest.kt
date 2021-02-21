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
import org.junit.Before
import org.junit.Test

class SessionsViewModelTest : BaseViewModelTest() {
    private val sessionRepository = mockk<SessionRepository>()
    lateinit var sessionsViewModel: SessionsViewModel

    @Before
    fun setUp() {
        sessionsViewModel = SessionsViewModel(sessionRepository)
    }

//    @Test
// FIXME:
// Here, I'd like to test that correct sessions were returned based on the `showBookmarked` boolean.
// But I do not know how to do it. Someone please help me
//    fun `test that sessions scheduled are fetched`() {
//        coEvery { sessionRepository.fetchSessionsSchedule("Day 1") } returns Data.Success(
//            testSessions
//        )
//        runBlocking {
//            sessionsViewModel.fetchSessions(Pair(false, "Day 1"))
//        }
//        coVerify { sessionRepository.fetchSessionsSchedule("Day 1") }
//        sessionsViewModel.filteredSessions.test().assertValue(testSessions)
//    }

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
            sessionsViewModel.fetchSessions(Pair(false, "Day 1"))
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