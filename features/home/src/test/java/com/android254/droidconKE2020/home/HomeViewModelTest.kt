package com.android254.droidconKE2020.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.home.di.homeViewModels
import com.android254.droidconKE2020.home.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.home.viewmodel.*
import io.mockk.MockKAnnotations
import org.junit.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class HomeViewModelTest : KoinTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @Before
    fun before() {
        startKoin { modules(homeViewModels) }
        MockKAnnotations.init(this)
    }

    @After
    fun after() {
        stopKoin()
    }

    private val homeViewModel: HomeViewModel by inject()

    private val promoRepo: FakePromotionRepository by inject()
    private val sessionRepo: FakeSessionRepository by inject()
    private val speakerRepo: FakeSpeakerRepository by inject()
    private val sponsorRepo: FakeSponsorRepository by inject()
    private val organizerRepo: FakeOrganizerRepository by inject()

    @Test
    fun `test that a promotion is retrieved when checkForNewPromo() is called`() {
        println("Action: Retrieving promotion without calling checkForNewPromo()")
        println("Expected: Null")

        var promo = homeViewModel.activePromo.getOrAwaitValue()
        println("Value: $promo")

        Assert.assertNull(promo)

        homeViewModel.checkForNewPromo()
        println("Action: Retrieving promotion after calling checkForNewPromo()")

        val expectedPromo = promoRepo.activePromo.getOrAwaitValue()
        println("Expected: $expectedPromo")

        promo = homeViewModel.activePromo.getOrAwaitValue()
        println("Value: $promo")

        Assert.assertEquals(promo, expectedPromo)

        println("######## \n")
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
    fun `test that sessions are retrieved when retrieveSessionList() is called`() {
        println("Action: Retrieving sessions")
        homeViewModel.retrieveSessionList()

        val expectedResults = sessionRepo.sessions.getOrAwaitValue()
        println("Expected: $expectedResults")

        val sessions = homeViewModel.sessionList.getOrAwaitValue()
        println("Value: $sessions")

        Assert.assertEquals(sessions, expectedResults)

        println("######## \n")
    }

    @Test
    fun `test that keynote speaker retrieved has attribute isKeynoteSpeaker set to true`() {
        println("Action: Retrieving keynote speaker")
        homeViewModel.retrieveSpeakerList()

        val expectedSpeaker = speakerRepo.keynoteSpeaker.getOrAwaitValue()
        println("Expected: $expectedSpeaker")
        println("Expected: isKeynoteSpeaker = true ")

        val speaker = homeViewModel.keynoteSpeaker.getOrAwaitValue()
        println("Value: $speaker")
        Assert.assertEquals(speaker, expectedSpeaker)

        println("Value: isKeynoteSpeaker = ${speaker?.isKeynoteSpeaker}")
        Assert.assertTrue(speaker?.isKeynoteSpeaker ?: false)

        println("######## \n")
    }

    @Test
    fun `test that session speakers are retrieved when retrieveSpeakerList() is called`() {
        println("Action: Retrieving session speaker")
        homeViewModel.retrieveSpeakerList()

        val expectedResults = speakerRepo.sessionSpeakers.getOrAwaitValue()
        println("Expected: $expectedResults")

        val speakers = homeViewModel.speakerList.getOrAwaitValue()
        println("Value: $speakers")

        Assert.assertEquals(speakers, expectedResults)

        // Ensure Keynote speaker doesn't show up in session speakers
        speakers?.forEach { Assert.assertFalse(it.isKeynoteSpeaker) }

        println("######## \n")
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
    fun `test that sponsors are retrieved when retrieveSponsors() is called`() {
        println("Action: Retrieving sponsors")
        homeViewModel.retrieveSponsors()

        val expectedResults = sponsorRepo.sponsors.getOrAwaitValue()
        println("Expected: $expectedResults")

        val sponsors = homeViewModel.sponsors.getOrAwaitValue()
        println("Value: $sponsors")

        Assert.assertEquals(sponsors, expectedResults)

        println("######## \n")
    }

    @Test
    fun `test that organizers are retrieved when retrieveOrganizerList() is called`() {
        println("Action: Retrieving organizers")
        homeViewModel.retrieveOrganizerList()

        val expectedResults = organizerRepo.organizers.getOrAwaitValue()
        println("Expected: $expectedResults")

        val organizers = homeViewModel.organizerList.getOrAwaitValue()
        println("Value: $organizers")

        Assert.assertEquals(organizers, expectedResults)

        println("######## \n")
    }
}