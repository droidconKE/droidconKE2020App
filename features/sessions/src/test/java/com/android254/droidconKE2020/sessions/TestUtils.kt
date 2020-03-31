package com.android254.droidconKE2020.sessions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.android254.droidconKE2020.sessions.ui.views.adapter.DummySession
import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 50,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

open class BaseViewModelTest {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
}

val testSession = DummySession(
    sessionSpeaker = "James Kirwa",
    sessionTitle = "Coroutines In Depth",
    sessionVenue = "Twiga Foods",
    sessionDescription = "A beginner guide to asynchronous programming",
    sessionStartTime = "9:00 AM",
    sessionEndTime = "9:30 AM",
    sessionTimeZone = "AM"
)