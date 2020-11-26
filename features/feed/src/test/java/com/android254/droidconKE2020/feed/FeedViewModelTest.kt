package com.android254.droidconKE2020.feed

import androidx.paging.PagingData
import com.android254.droidconKE2020.core.models.FeedUIModel
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
        val data = listOf(
            FeedUIModel("test", "http://test", "18:00")
        )
        coEvery { feedRepository.getFeed() } returns flowOf(PagingData.from(data))
        feedViewModel.getFeeds()
        coVerify { feedRepository.getFeed() }
        feedViewModel.getFeeds().test().assertHasValue()
    }
}