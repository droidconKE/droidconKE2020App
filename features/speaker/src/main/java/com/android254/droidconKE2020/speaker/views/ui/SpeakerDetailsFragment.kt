package com.android254.droidconKE2020.speaker.views.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android254.droidconKE2020.speaker.R
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding
import com.android254.droidconKE2020.speaker.di.speakerModule
import com.android254.droidconKE2020.speaker.models.SpeakerDetailsModel
import com.android254.droidconKE2020.speaker.views.viewmodels.SpeakerViewModel
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakerModule) }
private fun injectFeature() = loadFeature

class SpeakerDetailsFragment : Fragment() {
    private var _binding :FragmentSpeakerDetailsBinding?=null
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

        getSpeakerDetails()

        observeSpeakerDetails()
    }

    private fun observeSpeakerDetails() {
        speakerViewModel.speakerDetails.observe(viewLifecycleOwner, Observer { speakerDetailsModel ->
            setupView(speakerDetailsModel)
        })
    }

    private fun setupView(speakerDetailsModel: SpeakerDetailsModel) {
        with(speakerDetailsModel){
            binding.tvSpeakerName.text = speakerName
            binding.tvSpeakerRole.text = speakerRole
            binding.tvSpeakerCompany.text = speakerCompany
            binding.tvTopTwitterHandle.text = twitterHandle
            binding.tvSpeakerBio.text = speakerBio
            binding.tvSpeakerHandle.text = twitterHandle
        }
    }

    private fun getSpeakerDetails() {
        speakerViewModel.fetchSpeakerDetails()
    }
}