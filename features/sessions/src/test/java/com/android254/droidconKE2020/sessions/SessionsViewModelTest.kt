package com.android254.droidconKE2020.sessions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.sessions.ui.viewmodel.SessionsViewModel
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SessionsViewModelTest : BaseViewModelTest() {
    private val sessionRepository = mockk<SessionRepository>()
    lateinit var sessionsViewModel: SessionsViewModel

    @Before
    fun setUp() {
       sessionsViewModel = SessionsViewModel(sessionRepository)
    }

    @Test
    fun `test that sessions scheduled are fetched`() {
        coEvery { sessionRepository.fetchSessionsSchedule() } returns Data.Success(
            testSessionResponse)
        sessionsViewModel.fetchSessionsSchedule()
        coVerify { sessionRepository.fetchSessionsSchedule() }
        sessionsViewModel.sessionsSchedule.test().assertValue(Data.Success(testSessionResponse))
    }
}