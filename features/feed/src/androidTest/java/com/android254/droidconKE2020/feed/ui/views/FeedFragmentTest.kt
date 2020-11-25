package com.android254.droidconKE2020.feed.ui.views

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.agoda.kakao.screen.Screen.Companion.idle
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.android254.droidconKE2020.feed.ui.viewmodels.FeedViewModel
import com.android254.droidconKE2020.feed.ui.views.fragments.FeedFragment
import com.android254.droidconKE2020.repository.feed.FeedRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.mock.declare
import com.android254.droidconKE2020.R as AppR

@RunWith(AndroidJUnit4::class)
@LargeTest
class FeedFragmentTest : KoinTest {
    lateinit var feedViewModel: FeedViewModel
    private val feedRepository = mockk<FeedRepository>()

    @Before
    fun setup() {
        declare {
            feedViewModel = FeedViewModel(feedRepository)
        }
    }
    @Test
    fun testProgressBar_IsDisplayed_whenFeeds_AreLoading() {
        every { feedRepository.getFeed() } returns emptyFlow()
        launchFragmentInContainer<FeedFragment>(themeResId = AppR.style.Theme_DroidConKe)
        onScreen<FeedScreen> {
            noFeeds.isDisplayed()
        }
        idle(3000)
    }
}