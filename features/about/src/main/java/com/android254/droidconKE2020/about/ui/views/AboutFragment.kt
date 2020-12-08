package com.android254.droidconKE2020.about.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.databinding.FragmentAboutBinding
import com.android254.droidconKE2020.about.di.aboutModule
import com.android254.droidconKE2020.about.ui.adapters.OrganizerAdapter
import com.android254.droidconKE2020.about.ui.viewmodel.AboutViewModel
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(aboutModule) }
private fun injectFeature() = loadFeature

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private val aboutViewModel: AboutViewModel by viewModel()
    private val organizersViewModel : OrganizerViewModel by viewModel()
    private lateinit var organizerAdapter: OrganizerAdapter

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
        _binding?.viewModel = aboutViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        organizerAdapter= OrganizerAdapter {
            val organizerDetailsDirections =
                AboutFragmentDirections.actionAboutFragmentToOrganizerDetailsFragment()
            findNavController().navigate(organizerDetailsDirections)
        }
        organizersViewModel.fetchOrganizers()
        observeOrganizers()
        binding.organizersList.adapter = organizerAdapter


    }

    private fun observeOrganizers() {
        organizersViewModel.organizers.observe(viewLifecycleOwner){organizers ->
            organizerAdapter.submitList(organizers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}