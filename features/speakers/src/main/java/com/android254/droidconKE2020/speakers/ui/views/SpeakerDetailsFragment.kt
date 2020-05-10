package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakersModule) }
private fun injectFeature() = loadFeature

class SpeakerDetailsFragment : Fragment() {
    private var _binding: FragmentSpeakerDetailsBinding? = null
    private val binding get() = _binding!!
    private val speakerDetailsViewModel: SpeakerDetailsViewModel by viewModel()

    private var callback: OnBackPressedCallback? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()

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
        _binding = FragmentSpeakerDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.btnNavBack.setOnClickListener {
            callback!!.handleOnBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSpeakerDetails()
        getSpeakerDetails()
    }

    private fun observeSpeakerDetails() {
        speakerDetailsViewModel.speakerDetails.observe(viewLifecycleOwner, Observer { speaker ->
            speaker?.let { binding.speaker = speaker }
        })
    }

    private fun getSpeakerDetails() {
        val args: SpeakerDetailsFragmentArgs by navArgs()
        speakerDetailsViewModel.fetchSpeakerDetails(args.speakerId)
    }
}