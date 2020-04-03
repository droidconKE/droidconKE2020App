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

private val loadFeature by lazy { loadKoinModules(homeModule) }

class HomeFragment : Fragment(R.layout.fragment_home) {
    private fun injectFeature() = loadFeature

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
        val callForSpeakerUrl = homeViewModel.callForSpeakerUrl
        binding.applyBtn.setOnClickListener { launchBrowser(callForSpeakerUrl) }
        binding.cfpDescription.setOnClickListener { launchBrowser(callForSpeakerUrl) }
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
                    launchBrowser(homeViewModel.callForSpeakerUrl)
                }
            }
        })
    }

    private fun showSessionsList() {
        binding.viewSessionsBtn.setOnClickListener {
            val sessionsFragmentAction =
                HomeFragmentDirections.actionHomeFragmentToSessionsFragment()
            findNavController().navigate(sessionsFragmentAction)
        }

        val adapter = SessionAdapter()
        binding.sessionsList.adapter = adapter
        binding.sessionsList.addItemDecoration(HorizontalSpaceDecoration(20))

        homeViewModel.sessionList.observe(viewLifecycleOwner, Observer { sessions ->
            if (sessions == null) {
                binding.sessionCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                binding.sessionCountChip.visibility = View.VISIBLE
                binding.sessionCountChip.text = "${sessions.size}"
                adapter.updateData(sessions)
            }
        })

        homeViewModel.retrieveSessionList()
    }

    private fun showSpeakersList() {
        homeViewModel.isShowingAllSpeakers.observe(viewLifecycleOwner, Observer { isShowing ->
            binding.viewSpeakersBtn.text =
                getString(if (isShowing == true) R.string.view_less else R.string.view_all)
            binding.viewSpeakersBtn.setOnClickListener {
                if (isShowing == true) {
                    // ToDo: Show one row of speakers
                } else {
                    // ToDo: Set layoutManager to a grid and show all speakers
                }
                homeViewModel.setIsShowingAllSpeakers(isShowing != true)
            }
        })

        val adapter = SpeakerAdapter()
        binding.speakersList.adapter = adapter
        binding.speakersList.addItemDecoration(HorizontalSpaceDecoration(30))

        homeViewModel.speakerList.observe(viewLifecycleOwner, Observer
        { speakers ->
            if (speakers == null) {
                binding.speakersCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                binding.speakersCountChip.visibility = View.VISIBLE
                binding.speakersCountChip.text = "${speakers.size}"
                adapter.updateData(speakers)
            }
        })

        homeViewModel.retrieveSpeakerList()
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