package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakersModule) }
private fun injectFeature() = loadFeature

class SpeakerDetailsFragment : Fragment() {
    private var _binding : FragmentSpeakerDetailsBinding?=null
    private val binding get() = _binding!!
    private val speakerViewModel : SpeakerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpeakerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.speakerImg = "https://firebasestorage.googleapis.com/v0/b/droidconke-70d60.appspot.com/o/speakers2019%2Fjabez-mu.png?alt=media&token=ece3cbbd-b896-4748-9d9a-39e58391db92"

        observeSpeakerDetails()
        getSpeakerDetails()

    }

    private fun observeSpeakerDetails() {
        speakerViewModel.speakerDetails.observe(viewLifecycleOwner, Observer { speakerDetailsModel ->
            binding.speakerDetailsModel = speakerDetailsModel
        })
    }

    private fun getSpeakerDetails() {
        speakerViewModel.fetchSpeakerDetails()
    }
}