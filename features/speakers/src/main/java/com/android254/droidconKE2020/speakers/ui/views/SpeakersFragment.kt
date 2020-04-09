package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.ui.adapters.SpeakerAdapter
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy {
    loadKoinModules(listOf(speakersModule))
}

class SpeakersFragment : Fragment() {
    private fun injectFeature() = loadFeature

    private val speakersViewModel: SpeakersViewModel by viewModel()

    private lateinit var binding: FragmentSpeakersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpeakersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSpeakersList()
    }

    private fun showSpeakersList() {
        val adapter = SpeakerAdapter()
        binding.rvSpeakers.adapter = adapter

        speakersViewModel.speakerList.observe(viewLifecycleOwner, Observer { speakers ->
            if (speakers == null) {
                // ToDo: show shimmer
            } else adapter.submitList(speakers)
        })
        speakersViewModel.retrieveSpeakerList()
    }
}