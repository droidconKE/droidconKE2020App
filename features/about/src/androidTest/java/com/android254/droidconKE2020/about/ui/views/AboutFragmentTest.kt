package com.android254.droidconKE2020.about.ui.views

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.android254.droidconKE2020.about.R
import org.junit.Test
import org.junit.runner.RunWith
import com.android254.droidconKE2020.R as AppR

@RunWith(AndroidJUnit4::class)
@LargeTest
class AboutFragmentTest {

    @Test
    fun testCoverImage_IsDisplayed() {
        val scenario = launchFragmentInContainer<AboutFragment>(themeResId = AppR.style.Theme_DroidConKe)

        onScreen<AboutScreen> {
            aboutImage {
                isVisible()
//                hasDrawable(R.drawable.team)
            }
        }
    }

    @Test
    fun testAboutContent_IsDisplayed() {
        val scenario = launchFragmentInContainer<AboutFragment>(themeResId = AppR.style.Theme_DroidConKe)

        onScreen<AboutScreen> {
            aboutContent {
                isVisible()
                hasText(R.string.about_content)
            }
        }
    }
}