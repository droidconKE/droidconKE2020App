package com.android254.droidconKE2020.home

import com.android254.droidconKE2020.home.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.home.ui.viewmodel.*
import com.android254.droidconKE2020.repository.Data
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
    private val sponsorRepo = mockk<FakeSponsorRepository>()
    private val organizerRepo = mockk<FakeOrganizerRepository>()

    @Before
    fun before() {
        homeViewModel = HomeViewModel(promoRepo, sessionsRepository, speakerRepo, sponsorRepo, organizerRepo)
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
    fun `test that a the sponsor registration email addresses and subject exists`() {
        println("Action: Retrieving Become Sponsor email parameters")
        println("Expected: Array of emails addresses")
        println("Expected: String of email subject")

        val emails: Array<String>? = homeViewModel.becomeSponsorEmails
        println("Value: ${emails?.joinToString(",")}")

        val subject: String? = homeViewModel.becomeSponsorSubject
        println("Value: $subject")

        Assert.assertFalse(emails.isNullOrEmpty())
        Assert.assertFalse(subject.isNullOrBlank())

        println("######## \n")
    }

    @Test
    fun `test show toast has value when error occurs`() {
        coEvery { sessionsRepository.fetchAllSessions() } returns Data.Error("Error Occurred")
        homeViewModel.fetchAllSessions()
        coVerify { sessionsRepository.fetchAllSessions() }
        homeViewModel.showToast.test().assertValue("Error Occurred")
    }
}