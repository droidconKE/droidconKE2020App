package com.android254.droidconKE2020.about.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.databinding.FragmentAboutBinding
import com.android254.droidconKE2020.about.di.aboutModule
import com.android254.droidconKE2020.about.ui.adapters.CompanyOrganizersAdapter
import com.android254.droidconKE2020.about.ui.adapters.OrganizerAdapter
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.repository.repoModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(aboutModule, repoModule)) }
private fun injectFeature() = loadFeature

class AboutFragment : Fragment(R.layout.fragment_about) {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private val organizersViewModel: OrganizerViewModel by viewModel()
    private lateinit var organizerAdapter: OrganizerAdapter
    private lateinit var companyOrganizerAdapter: CompanyOrganizersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        organizerAdapter = OrganizerAdapter { organizerUIModel ->
            val organizerDetailsDirections =
                AboutFragmentDirections.actionAboutFragmentToOrganizerDetailsFragment(organizerUIModel)
            findNavController().navigate(organizerDetailsDirections)
        }
        companyOrganizerAdapter = CompanyOrganizersAdapter()
        binding.organizersList.adapter = organizerAdapter
        binding.rvCompanyOrganizers.adapter = companyOrganizerAdapter
        organizersViewModel.fetchOrganizers()
        observeOrganizers()
    }

    private fun observeOrganizers() {
        organizersViewModel.organizers.observe(viewLifecycleOwner) { organizers ->
            organizerAdapter.submitList(organizers.filter { it.organizerType == "individual" })
            companyOrganizerAdapter.submitList(organizers.filter { it.organizerType == "company" })
        }
        organizersViewModel.showToast.observe(viewLifecycleOwner) { errorMessage ->
            requireContext().toast(errorMessage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}