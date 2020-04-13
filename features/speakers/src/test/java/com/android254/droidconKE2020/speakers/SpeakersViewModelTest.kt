package com.android254.droidconKE2020.speakers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import io.mockk.MockKAnnotations
import org.junit.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class SpeakersViewModelTest : KoinTest {

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

    private val speakerViewModel: SpeakersViewModel by inject()

    private val speakerRepo: FakeSpeakerRepository by inject()

    @Test
    fun `test that searchPhrase can be modified`() {
        println("Action: Searching Speaker")
        val newSearchPhrase = "juma allan"
        speakerViewModel.searchPhrase.postValue(newSearchPhrase)

        println("Expected: $newSearchPhrase")

        val searchPhrase = speakerViewModel.searchPhrase.getOrAwaitValue()
        println("Value: $searchPhrase")

        Assert.assertEquals(searchPhrase, newSearchPhrase)

        println("######## \n")
    }

    @Test
    fun `test that speakers matching a searchPhrase can be retrieved`() {
        println("Action: Searching a speaker")
        val searchPhrase = "juma allan"
        speakerViewModel.retrieveSpeakerList(searchPhrase)

        val expectedResults = speakerRepo.sessionSpeakers.getOrAwaitValue()
        println("Expected: Speakers containing $searchPhrase ($expectedResults")

        val speakers = speakerViewModel.speakerList.getOrAwaitValue()
        println("Value: $speakers")

        Assert.assertEquals(speakers, expectedResults)

        println("######## \n")
    }

    @Test
    fun `test that speakers are retrieved when retrieveSpeakerList() is called`() {
        println("Action: Retrieving all speakers")
        speakerViewModel.retrieveSpeakerList(null)

        val expectedResults = speakerRepo.sessionSpeakers.getOrAwaitValue()
        println("Expected: All speakers ($expectedResults)")

        val speakers = speakerViewModel.speakerList.getOrAwaitValue()
        println("Value: $speakers")

        Assert.assertEquals(speakers, expectedResults)

        println("######## \n")
    }

}