package com.android254.droidconKE2020.feed

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android254.droidconKE2020.feed.ui.views.FeedViewModel
import com.android254.droidconKE2020.feed.ui.views.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FeedViewModelTest {

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var context: Context

    @InjectMockKs
    lateinit var viewModel: FeedViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test blank is not shown`() {
        assertThat(viewModel.blank.getOrAwaitValue(), `is`(false))
    }
}