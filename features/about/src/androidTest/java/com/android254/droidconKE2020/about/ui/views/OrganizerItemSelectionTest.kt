package com.android254.droidconKE2020.about.ui.views

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android254.droidconKE2020.about.ui.viewmodel.AboutViewModel
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * 09/04/20
 */
@RunWith(AndroidJUnit4::class)
class OrganizerItemSelectionTest {

    private lateinit var scenario: FragmentScenario<AboutFragment>
    private lateinit var viewModel: AboutViewModel
    private lateinit var organizerList: List<Organizer>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<AboutFragment>()
        viewModel = AboutViewModel()
    }

    @Test
    fun organizerSelected() {
        scenario.onFragment {  fragment ->
            viewModel.createDummyData()
            viewModel.organizers.observe(fragment, Observer {
                organizerList = it
            })
        }

        onData(allOf(instanceOf(Organizer::class.java), equalTo(organizerList[0]))).perform(click())
    }
}