package com.android254.droidconKE2020.home.ui.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
import com.android254.droidconKE2020.home.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import kotlin.random.Random

private val loadFeature by lazy { loadKoinModules(homeModule) }
private fun injectFeature() = loadFeature

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModel()

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
        showPromoCard()
        showCallForSpeakersCard()
        showKeynoteInfoCard()
        showSessionsList()
        showSpeakersList()
        showSponsors()
        showOrganizers()
    }

    private fun launchBrowser(webUrl: String) {
        // ToDo: replace wit in-app browser
        startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(webUrl)))
    }

    private fun onSpeakerClicked(speakerId: Int) {
        val speakerDetailsAction =
            HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment()
        findNavController().navigate(speakerDetailsAction)
    }

    private fun showPromoCard() {
        // Check for any available promos
        homeViewModel.ongoingPromo.observe(viewLifecycleOwner, Observer { promo ->
            binding.promoImg.visibility = if (promo != null) View.VISIBLE else View.GONE
            promo?.let {
                binding.promoImg.load(promo.imageUrl.toInt()) // ToDo: Remove the int cast upon introducing real data
                binding.promoImg.setOnClickListener { launchBrowser(promo.webUrl) }
            }
        })

        // Check for new promos after every minute
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                homeViewModel.checkForNewPromo()
                delay(60 * 1000)
            }
        }
    }

    private fun showCallForSpeakersCard() {
        binding.cfpImage.load(R.drawable.cfp_image)
    }

    private fun showKeynoteInfoCard() {
        homeViewModel.retrieveKeynoteSpeaker()

        homeViewModel.keynoteSpeaker.observe(viewLifecycleOwner, Observer { keynoteSpeaker ->
            if (keynoteSpeaker == null) {
                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                binding.keynoteSpeakerImg.also {
                    it.load(keynoteSpeaker.imageUrl)
                    it.setOnClickListener { onSpeakerClicked(keynoteSpeaker.id) }
                }
                binding.keynoteSpeakerLbl.also {
                    it.text = keynoteSpeaker.name
                    it.setOnClickListener { onSpeakerClicked(keynoteSpeaker.id) }
                }
                binding.keynoteLblBecomeSpeaker.setOnClickListener {
                    binding.applyBtn.callOnClick()
                }
            }
        })
    }

    private fun showSessionsList() {
        val onClicked: (Session) -> Unit = {
            val sessionDetailsAction =
                HomeFragmentDirections.actionHomeFragmentToSessionDetailsFragment(0)
            findNavController().navigate(sessionDetailsAction)
        }

        val adapter = SessionAdapter(onClicked)
        binding.sessionsList.adapter = adapter
        binding.sessionsList.addItemDecoration(HorizontalSpaceDecoration(20))

        adapter.updateData(createDummyData())
    }

    private fun showSpeakersList() {
        val speakersAdapter = SpeakerAdapter()
        binding.speakersList.adapter = speakersAdapter
        binding.speakersList.addItemDecoration(HorizontalSpaceDecoration(30))
        speakersAdapter.updateData(createDummySpeakerData())
    }

    private fun showSponsors() {
    }

    private fun showOrganizers() {
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
                    id = Random.nextInt(),
                    name = "Person $i",
                    imageUrl = "https://loremflickr.com/320/320/dog"
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