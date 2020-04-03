package com.android254.droidconKE2020.home.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.api.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.databinding.FragmentHomeBinding
import com.android254.droidconKE2020.home.di.homeModule
import com.android254.droidconKE2020.home.domain.Organizer
import com.android254.droidconKE2020.home.domain.Session
import com.android254.droidconKE2020.home.domain.Speaker
import com.android254.droidconKE2020.home.ui.adapters.OrganizerAdapter
import com.android254.droidconKE2020.home.ui.adapters.SessionAdapter
import com.android254.droidconKE2020.home.ui.adapters.SpeakerAdapter
import org.koin.core.context.loadKoinModules

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val loadFeature by lazy { loadKoinModules(homeModule) }
    private fun injectFeature() = loadFeature

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.promoImg.load(R.drawable.black_friday_twitter)
        binding.cfpImage.load(R.drawable.cfp_image)
        val onClicked: (Session) -> Unit = {
            val sessionDetailsAction =
                HomeFragmentDirections.actionHomeFragmentToSessionDetailsFragment(0)
            findNavController().navigate(sessionDetailsAction)
        }
        val sessionsAdapter = SessionAdapter(onClicked)
        binding.sessionsList.adapter = sessionsAdapter
        binding.sessionsList.addItemDecoration(
            HorizontalSpaceDecoration(20)
        )
        sessionsAdapter.updateData(createDummyData())

        val onSpeakerClicked: (Speaker) -> Unit = {
            val speakerDetailsAction =
                HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment()
            findNavController().navigate(speakerDetailsAction)
        }
        val speakersAdapter = SpeakerAdapter(onSpeakerClicked)
        binding.speakersList.adapter = speakersAdapter
        binding.speakersList.addItemDecoration(
            HorizontalSpaceDecoration(30)
        )
        speakersAdapter.updateData(createDummySpeakerData())

        val organizerAdapter = OrganizerAdapter()
        binding.organizersList.adapter = organizerAdapter
        organizerAdapter.updateData(createDummyOrganizers())

        binding.sponsor1Img.load(R.drawable.google)
        binding.sponsor2Img.load(R.drawable.andela)
        binding.sponsor3Img.load(R.drawable.hover)
        binding.sponsor4Img.load(R.drawable.jetbrains)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun createDummyData(): List<Session> {
        val list = mutableListOf<Session>()
        for (i in 0 until 10) {
            list.add(
                Session(
                    description = "Some short description",
                    room = "Room $i",
                    time = "10:5$i",
                    imageUrl = ""
                )
            )
        }
        return list
    }

    private fun createDummySpeakerData(): List<Speaker> {
        val list = mutableListOf<Speaker>()
        for (i in 0 until 10) {
            list.add(
                Speaker(
                    name = "Person $i",
                    imageUrl = ""
                )
            )
        }
        return list
    }

    private fun createDummyOrganizers(): List<Organizer> {
        val list = mutableListOf<Organizer>()
        for (i in 0 until 10) {
            list.add(
                Organizer(imageUrl = "")
            )
        }
        return list
    }
}