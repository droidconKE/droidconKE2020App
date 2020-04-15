package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.models.Speaker
import com.android254.droidconKE2020.speakers.ui.adapters.SpeakerAdapter
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakersModule) }

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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.speakersViewModel = speakersViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.setGoBack { findNavController().navigateUp() }
        binding.setOpenProfile { Log.e("SpeakersFragment", "OpenProfile") }

        binding.setClearSearch { speakersViewModel.clearSearch() }
        binding.setInitiateEasterEgg { Log.e("SpeakersFragment", "InitiateEasterEgg") }

        observeSpeakers()
        fetchSpeakers(null)

        listenForSearchEvent()
    }

    private val onSpeakerClicked: (Speaker) -> Unit = {
        val speakerDetailsAction =
            SpeakersFragmentDirections.actionSpeakersFragmentToSpeakerDetailsFragment(it.id)
        findNavController().navigate(speakerDetailsAction)
    }


    private fun fetchSpeakers(searchPhrase: String?) {
        speakersViewModel.retrieveSpeakerList(searchPhrase)
    }

    private fun observeSpeakers() {
        val adapter = SpeakerAdapter(onSpeakerClicked)
        binding.rvSpeakers.adapter = adapter

        speakersViewModel.speakerList.observe(viewLifecycleOwner, Observer { speakers ->
            if (speakers != null) adapter.submitList(speakers)
            else {
                // ToDo: show shimmer for the first time and null views for conseq times.
                //  This can be null due to the search functionality
            }
        })
    }

    private fun listenForSearchEvent() {
        speakersViewModel.clearSearch()
        speakersViewModel.searchPhrase.observe(viewLifecycleOwner, Observer { searchPhrase ->
            binding.tvSearch.isCursorVisible = !searchPhrase.isNullOrEmpty()
            fetchSpeakers(searchPhrase)
        })
    }

}