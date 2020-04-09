package com.android254.droidconKE2020.speaker.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding

class SpeakersFragment : Fragment() {
    private lateinit var binding: FragmentSpeakerDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpeakerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

}