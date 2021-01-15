package com.android254.droidconKE2020.about.ui.viewmodel

import com.android254.droidconKE2020.about.testOrganisers
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.organizers.OrganizersRepository
import com.android254.droidconKE2020.test_utils.BaseViewModelTest
import com.jraska.livedata.test
import io.mockk.*
import org.junit.Before
import org.junit.Test

/**
 * 09/04/20
 */
class AboutViewModelTest : BaseViewModelTest() {
    private val organizersRepository = mockk<OrganizersRepository>()
    lateinit var organizersViewModel: OrganizerViewModel

    @Before
    fun setup() {
        organizersViewModel = OrganizerViewModel(organizersRepository)
    }

    @Test
    fun `test organizers are fetched successfully`() {
        coEvery { organizersRepository.fetchOrganizers() } returns Data.Success(testOrganisers)
        organizersViewModel.fetchOrganizers()
        coVerify { organizersRepository.fetchOrganizers() }
        organizersViewModel.organizers.test().assertValue(testOrganisers)
    }

    @Test
    fun `test toast is shown when error occurs when fetching organizers`() {
        coEvery { organizersRepository.fetchOrganizers() } returns Data.Error("An error occurred")
        organizersViewModel.fetchOrganizers()
        coVerify { organizersRepository.fetchOrganizers() }
        organizersViewModel.showToast.test().assertValue("An error occurred")
    }
}