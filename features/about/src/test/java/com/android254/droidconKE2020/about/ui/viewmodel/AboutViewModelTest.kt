package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.android254.droidconKE2020.about.ui.views.Organizer
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import org.junit.Rule

/**
 * 09/04/20
 */
class AboutViewModelTest {
    @Rule @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AboutViewModel

    private var organizerList = listOf<Organizer>()
    private lateinit var observer: Observer<List<Organizer>>

    @Before
    fun setUp() {
        viewModel = AboutViewModel()

        observer = createOrganizersObserver()
        viewModel.organizers.observeForever(observer)
    }

    @Test
    fun createDummyData_OrganizerListObserver_VerifiedCorrectly() {
        viewModel.createDummyData()

        val slots = mutableListOf<List<Organizer>>()
        verify { observer.onChanged(capture(slots)) }
    }

    @Test
    fun createDummyData_OrganizerListIsNotEmpty_VerifiedCorrectly() {
        viewModel.createDummyData()

        val slots = mutableListOf<List<Organizer>>()
        verify { observer.onChanged(capture(slots)) }

        organizerList = slots[0]
        assertTrue(organizerList.isNotEmpty())
    }

    private fun createOrganizersObserver(): Observer<List<Organizer>> = spyk(Observer {})
}