package com.android254.droidconKE2020.speakers

import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class SpeakerDetailsViewModelTest {

    private lateinit var speakerDetailsViewModel: SpeakerDetailsViewModel

    @Before
    fun setup() {
        speakerDetailsViewModel = SpeakerDetailsViewModel()
    }

    @Test
    fun `test getHandleFromUrl`() {
        assertThat(
            speakerDetailsViewModel.getHandleFromUrl("https://twitter.com/test"),
            `is`("@test")
        )
    }
}