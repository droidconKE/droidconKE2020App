package com.android254.droidconKE2020.about.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android254.droidconKE2020.about.R
import com.android254.droidconKE2020.about.databinding.FragmentOrganizerDetailsBinding
import com.android254.droidconKE2020.about.di.loadModules
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import org.koin.android.viewmodel.ext.android.viewModel

private fun injectFeatures() = loadModules

class OrganizerDetailsFragment : Fragment(R.layout.fragment_organizer_details) {
    private var callback: OnBackPressedCallback? = null
    private var _binding: FragmentOrganizerDetailsBinding? = null
    private val binding get() = _binding!!
    private val organizerDetailsFragmentArgs: OrganizerDetailsFragmentArgs by navArgs()
    private val organizerUIModel by lazy {
        organizerDetailsFragmentArgs.organizerUIModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeatures()

        callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            isEnabled = true
            findNavController().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrganizerDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.organizerUIModel = organizerUIModel

        binding.btnNavBack.setOnClickListener {
            callback!!.handleOnBackPressed()
        }
        return binding.root
    }
}