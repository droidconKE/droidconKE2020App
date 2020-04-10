package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.speaker.R
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.models.Speaker
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

        binding.setGoBack { findNavController().navigateUp() }
        binding.setOpenProfile { Log.e("openProfile", "Clicked") }

        searchSpeaker()
        showSpeakersList()
    }

    private val onSpeakerClicked: (Speaker) -> Unit = {
        val speakerDetailsAction =
            SpeakersFragmentDirections.actionSpeakersFragmentToSpeakerDetailsFragment(it.id)
        findNavController().navigate(speakerDetailsAction)
    }

    private val onStarClicked: (Int) -> Unit =
        { speakerId -> speakersViewModel.adjustStars(speakerId) }

    private fun searchSpeaker() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.speakersViewModel = speakersViewModel

        speakersViewModel.searchPhrase.observe(viewLifecycleOwner, Observer { searchPhrase ->
            with(binding.imgLogo) {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        if (searchPhrase.isNullOrEmpty()) com.android254.droidconKE2020.R.drawable.ic_droidcon_logo
                        else R.drawable.ic_clear_24px
                    )
                )

                setOnClickListener {
                    if (searchPhrase.isNullOrEmpty())
                        Toast.makeText(context, "Easter Egg", Toast.LENGTH_SHORT).show()
                    else speakersViewModel.setSearchPhrase("")
                }

                binding.tvSearch.isCursorVisible = !searchPhrase.isNullOrEmpty()
                speakersViewModel.retrieveSpeakerList(searchPhrase)
            }
        })
        speakersViewModel.setSearchPhrase("")
    }

    private fun showSpeakersList() {
        val adapter = SpeakerAdapter(onSpeakerClicked, onStarClicked)
        binding.rvSpeakers.adapter = adapter

        speakersViewModel.speakerList.observe(viewLifecycleOwner, Observer { speakers ->
            if (speakers == null) {
                // ToDo: show shimmer for the first time and null views for conseq times.
                //  This can be null due to the search functionality
            } else adapter.submitList(speakers)
        })

        speakersViewModel.retrieveSpeakerList(null)
    }
}