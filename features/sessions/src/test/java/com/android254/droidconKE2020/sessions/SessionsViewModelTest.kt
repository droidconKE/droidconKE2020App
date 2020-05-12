package com.android254.droidconKE2020.sessions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.sessions.ui.views.viewmodel.SessionsViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SessionsViewModelTest {

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @InjectMockKs
    lateinit var sessionsViewModel: SessionsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test that day sessions live data contains day sessions when getDaySessions() is called`() {
        sessionsViewModel.getDaySessions()
        assertThat(sessionsViewModel.daySessions.getOrAwaitValue().isNotEmpty(), `is`(true))
    }
}