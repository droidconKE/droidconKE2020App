package com.android254.droidconKE2020.about.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.databinding.FragmentOrganizerDetailsBinding
import com.android254.droidconKE2020.about.di.loadModules
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import org.koin.android.viewmodel.ext.android.viewModel

private fun injectFeaures() = loadModules

class OrganizerDetailsFragment : Fragment(R.layout.fragment_organizer_details) {
    private val organizerViewModel: OrganizerViewModel by viewModel()

    private var callback: OnBackPressedCallback? = null
    private var _binding: FragmentOrganizerDetailsBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeaures()

        callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            isEnabled = true

            findNavController().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrganizerDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.organizerViewModel = organizerViewModel

        binding.btnNavBack.setOnClickListener {
            callback!!.handleOnBackPressed()
        }
        return binding.root
    }
}