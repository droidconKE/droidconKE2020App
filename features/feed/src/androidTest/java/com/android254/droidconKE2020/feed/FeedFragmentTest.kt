package com.android254.droidconKE2020.feed

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.screen.Screen.Companion.idle
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.android254.droidconKE2020.feed.ui.views.FeedFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FeedFragmentTest {


    @Test
    fun testFeedsAreShown() {
        launchFragmentInContainer<FeedFragment>(themeResId = com.android254.droidconKE2020.R.style.AppTheme)
        onScreen<FeedScreen> {
            idle(5000)
            feedsList {
                firstChild<FeedItem> {
                    isVisible()
//                    title { hasText("Title 1") }
                }
            }
        }
    }
}