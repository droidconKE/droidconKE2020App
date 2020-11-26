package com.android254.droidconKE2020.feed

import com.android254.droidconKE2020.feed.ui.viewmodels.FeedViewModel
import com.android254.droidconKE2020.repository.feed.FeedRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test

class FeedViewModelTest : BaseViewModelTest() {
    private val feedRepository = mockk<FeedRepository>()
    private lateinit var feedViewModel: FeedViewModel

    @Before
    fun setup() {
        feedViewModel = FeedViewModel(feedRepository)
    }

    @Test
    fun `test feeds are fetched`() {
        coEvery { feedRepository.getFeed() } returns flowOf()
        feedViewModel.getFeeds()
        coVerify { feedRepository.getFeed() }
        // Investigate why this always brings Observer never received any value
        feedViewModel.getFeeds().test().assertHasValue()
    }
}