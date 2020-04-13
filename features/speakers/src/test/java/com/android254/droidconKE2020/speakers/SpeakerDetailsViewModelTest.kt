package com.android254.droidconKE2020.speakers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import io.mockk.MockKAnnotations
import org.junit.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class SpeakerDetailsViewModelTest : KoinTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @Before
    fun before() {
        startKoin { modules(speakersModule) }
        MockKAnnotations.init(this)
    }

    @After
    fun after() {
        stopKoin()
    }

    private val viewModel: SpeakerDetailsViewModel by inject()

    private val speakerRepo: FakeSpeakerRepository by inject()

    @Test
    fun `test that speaker matching supplied is can be retrieved`() {
        println("Action: Retrieving Speaker")
        speakerRepo.refreshSpeakers()
        val speakerId = 3
        viewModel.fetchSpeakerDetails(speakerId)

        val expectedSpeaker = speakerRepo.retrieveSpeaker(speakerId)
        println("Expected: Speaker With Id: $speakerId ($expectedSpeaker)")

        val speaker = viewModel.speakerDetails.getOrAwaitValue()
        println("Value: $speaker")

        Assert.assertEquals(speaker, expectedSpeaker)

        println("######## \n")
    }
}