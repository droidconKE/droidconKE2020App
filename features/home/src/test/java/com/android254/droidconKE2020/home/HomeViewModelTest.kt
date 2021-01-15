package com.android254.droidconKE2020.home

import com.android254.droidconKE2020.home.ui.viewmodel.FakePromotionRepository
import com.android254.droidconKE2020.home.ui.viewmodel.HomeViewModel
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.EventRepository
import com.android254.droidconKE2020.repository.organizers.OrganizersRepository
import com.android254.droidconKE2020.repository.sessions.SessionRepository
import com.android254.droidconKE2020.repository.speakers.SpeakerRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.stopKoin

class HomeViewModelTest : BaseViewModelTest() {
    private val sessionsRepository = mockk<SessionRepository>()
    private lateinit var homeViewModel: HomeViewModel
    private val promoRepo = mockk<FakePromotionRepository>()
    private val speakerRepo = mockk<SpeakerRepository>()
    private val eventRepository = mockk<EventRepository>()
    private val organizerRepo = mockk<OrganizersRepository>()

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
    fun `test that sessions are fetched successfully`() = runBlockingTest {
        coEvery { sessionsRepository.fetchAllSessions() } returns Data.Success(testSessions)
        homeViewModel.fetchAllSessions()
        coVerify { sessionsRepository.fetchAllSessions() }
        homeViewModel.sessions.test().assertValue(testSessions)
    }

    @Test
    fun `test show toast has value when error occurs`() = runBlockingTest {
        coEvery { sessionsRepository.fetchAllSessions() } returns Data.Error("Error Occurred")
        homeViewModel.fetchAllSessions()
        coVerify { sessionsRepository.fetchAllSessions() }
        homeViewModel.showToast.test().assertValue("Error Occurred")
    }

    @Test
    fun `test that sponsors are fetched successfully`() = runBlockingTest {
        coEvery { eventRepository.fetchSponsors() } returns Data.Success(testSponsors)
        homeViewModel.fetchSponsors()
        coVerify { eventRepository.fetchSponsors() }
        homeViewModel.sponsors.test().assertValue(testSponsors)
    }

    @Test
    fun `test organizers are fetched successfully`() = runBlockingTest {
        coEvery { organizerRepo.fetchOrganizers() } returns Data.Success(testOrganisers)
        homeViewModel.fetchOrganizers()
        coVerify { organizerRepo.fetchOrganizers() }
        homeViewModel.organizers.test().assertValue(testOrganisers)
    }

    @Test
    fun `test speakers are fetched successfully`() = runBlockingTest {
        coEvery { speakerRepo.fetchSomeSpeakers() } returns Data.Success(testSpeakers)
        homeViewModel.fetchSpeakers()
        coVerify { speakerRepo.fetchSomeSpeakers() }
        homeViewModel.speakers.test().assertValue(testSpeakers)
    }
}