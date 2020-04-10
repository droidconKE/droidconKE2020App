package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding
import com.android254.droidconKE2020.speakers.di.speakerModule
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakerModule) }
private fun injectFeature() = loadFeature

class SpeakerDetailsFragment : Fragment() {
    private lateinit var binding: FragmentSpeakerDetailsBinding
    private val speakerDetailsViewModel: SpeakerDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpeakerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: SpeakerDetailsFragmentArgs by navArgs()

        binding.lifecycleOwner = this

        observeSpeakerDetails()
        getSpeakerDetails(args.speakerId)
    }

    private fun observeSpeakerDetails() {
        speakerDetailsViewModel.speakerDetails.observe(viewLifecycleOwner, Observer { speaker ->
            binding.speaker = speaker
        })
    }

    private fun getSpeakerDetails(speakerId: Int) {
        speakerDetailsViewModel.fetchSpeakerDetails(speakerId)
    }
}