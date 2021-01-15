package com.android254.droidconKE2020.speakers

import androidx.paging.PagingData
import com.android254.droidconKE2020.repository.speakers.SpeakerRepository
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test

class SpeakersViewModelTest : BaseViewModelTest() {

    private val speakerRepository = mockk<SpeakerRepository>()
    private lateinit var speakersViewModel: SpeakersViewModel

    @Before
    fun before() {
        speakersViewModel = SpeakersViewModel(speakerRepository)
    }

    @Test
    fun `test loading of speakers with no search term`() {
        val data = listOf(sampleSpeaker)
        every { speakerRepository.fetchSpeakers() } returns flowOf(PagingData.from(data))

        val speakers = speakersViewModel.getSpeakers()

        verify { speakerRepository.fetchSpeakers() }

        speakers.test().assertHasValue()
    }

    @Test
    fun `test loading of speakers with search term`() {
        val data = listOf(sampleSpeaker)
        every { speakerRepository.fetchSpeakers() } returns flowOf(PagingData.from(data))

        val speakers = speakersViewModel.getSpeakers()

        verify { speakerRepository.fetchSpeakers() }

        speakersViewModel.searchTerm.value = "charles"

        speakers.test().assertHasValue()
    }
}