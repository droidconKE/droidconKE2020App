package com.android254.droidconKE2020.speakers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.repository.di.speakerReposModule
import com.android254.droidconKE2020.repository.repositories.FakeSpeakerRepository
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
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
        startKoin {
            modules(listOf(speakersModule, speakerReposModule))
        }
        MockKAnnotations.init(this)
    }

    @After
    fun after() {
        stopKoin()
    }

    private val speakerViewModel: SpeakersViewModel by inject()

    private val speakerRepo: FakeSpeakerRepository by inject()

}