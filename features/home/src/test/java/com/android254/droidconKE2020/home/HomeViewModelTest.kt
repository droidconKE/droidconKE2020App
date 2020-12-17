package com.android254.droidconKE2020.home

import com.android254.droidconKE2020.home.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.home.ui.viewmodel.*
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.EventRepository
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.*
import org.koin.core.context.stopKoin

class HomeViewModelTest : BaseViewModelTest() {
    private val sessionsRepository = mockk<SessionRepository>()
    private lateinit var homeViewModel: HomeViewModel
    private val promoRepo = mockk<FakePromotionRepository>()
    private val speakerRepo = mockk<FakeSpeakerRepository>()
    private val eventRepository = mockk<EventRepository>()
    private val organizerRepo = mockk<FakeOrganizerRepository>()

    @Before
    fun before() {
        homeViewModel = HomeViewModel(promoRepo, sessionsRepository, speakerRepo, eventRepository, organizerRepo)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `test that a the callForSpeakers registration url exists`() {
        println("Action: Retrieving callForSpeakers registration url")
        println("Expected: String (web url)")

        val url: String? = homeViewModel.callForSpeakerUrl
        println("Value: $url")

        Assert.assertFalse(url.isNullOrBlank())

        println("######## \n")
    }

    @Test
    fun `test that sessions are fetched successfully`() {
        coEvery { sessionsRepository.fetchAllSessions() } returns Data.Success(testSessions)
        homeViewModel.fetchAllSessions()
        coVerify { sessionsRepository.fetchAllSessions() }
        homeViewModel.sessions.test().assertHasValue()
    }

    @Test
    fun `test show toast has value when error occurs`() {
        coEvery { sessionsRepository.fetchAllSessions() } returns Data.Error("Error Occurred")
        homeViewModel.fetchAllSessions()
        coVerify { sessionsRepository.fetchAllSessions() }
        homeViewModel.showToast.test().assertValue("Error Occurred")
    }

    @Test
    fun `test that sponsors are fetched successfully`() {
        coEvery { eventRepository.fetchSponsors() } returns Data.Success(testSponsors)
        homeViewModel.fetchSponsors()
        coVerify { eventRepository.fetchSponsors() }
        homeViewModel.sponsors.test().assertHasValue()
    }
}