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
import com.android254.droidconKE2020.core.di.browserModule
import com.android254.droidconKE2020.core.utils.WebPages
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.databinding.FragmentHomeBinding
import com.android254.droidconKE2020.home.di.homeViewModels
import com.android254.droidconKE2020.home.domain.Sponsor
import com.android254.droidconKE2020.home.ui.adapters.*
import com.android254.droidconKE2020.home.viewmodel.HomeViewModel
import com.android254.droidconKE2020.home.domain.Speaker
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy {
    loadKoinModules(listOf(homeViewModels, browserModule))
}

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

    private fun viewAllSessionsClicked() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToSessionsFragment()
        findNavController().navigate(action)
    }

    private fun viewAllSpeakersClicked() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToSpeakersFragment()
        findNavController().navigate(action)
    }

    private fun onSpeakerClicked(speakerId: Int) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment(speakerId)
        findNavController().navigate(action)
    }

    private fun launchBrowser(webUrl: String) {
        val webPages: WebPages by inject()
        webPages.launchInAppBrowser(webUrl)
    }

    private fun sendEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            type = "message/rfc822"
            val uriText = "mailto:${addresses.joinToString(",")}?subject=$subject"
            data = Uri.parse(uriText)
        }
        if (intent.resolveActivity(requireContext().packageManager) != null) startActivity(intent)
    }

    private fun showPromoCard() {
        // Check for any available promos
        homeViewModel.activePromo.observe(viewLifecycleOwner, Observer { promo ->
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
        homeViewModel.retrieveSpeakerList()

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
        binding.viewSessionsBtn.setOnClickListener { viewAllSessionsClicked() }

        val adapter = SessionAdapter()
        binding.sessionsList.adapter = adapter
        binding.sessionsList.addItemDecoration(HorizontalSpaceDecoration(20))

        homeViewModel.sessionList.observe(viewLifecycleOwner, Observer { sessions ->
            if (sessions == null) {
                binding.sessionCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                binding.sessionCountChip.visibility = View.VISIBLE
                val totalSessions = "+${sessions.size}"
                binding.sessionCountChip.text = totalSessions
                adapter.updateData(sessions)
            }
        })

        homeViewModel.retrieveSessionList()
    }

    private fun showSpeakersList() {
        binding.viewSpeakersBtn.setOnClickListener { viewAllSpeakersClicked() }

        val onSpeakerClicked: (Speaker) -> Unit = { onSpeakerClicked(it.id) }
        val adapter = SpeakerAdapter(onSpeakerClicked)
        binding.speakersList.adapter = adapter
        binding.speakersList.addItemDecoration(HorizontalSpaceDecoration(30))

        homeViewModel.speakerList.observe(viewLifecycleOwner, Observer
        { speakers ->
            if (speakers == null) {
                binding.speakersCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                binding.speakersCountChip.visibility = View.VISIBLE
                val totalSpeakers = "+${speakers.size}"
                binding.speakersCountChip.text = totalSpeakers
                adapter.updateData(speakers)
            }
        })

        homeViewModel.retrieveSpeakerList()
    }

    private fun showSponsors() {
        binding.tvBecomeSponsor.setOnClickListener {
            sendEmail(homeViewModel.becomeSponsorEmails, homeViewModel.becomeSponsorSubject)
        }

        val onSponsorClicked: (Sponsor) -> Unit = { launchBrowser(it.website) }

        // ToDo: Merge two adapters to use a single list using MergeAdapter
        val goldAdapter = GoldSponsorAdapter(onSponsorClicked)
        binding.rvGoldSponsors.adapter = goldAdapter
        binding.rvGoldSponsors.layoutManager = FlexboxLayoutManager(requireContext()).also {
            it.flexDirection = FlexDirection.ROW
            it.flexWrap = FlexWrap.WRAP
            it.justifyContent = JustifyContent.SPACE_EVENLY
        }

        val otherAdapter = OtherSponsorAdapter(onSponsorClicked)
        binding.rvOtherSponsors.adapter = otherAdapter
        binding.rvOtherSponsors.layoutManager = FlexboxLayoutManager(requireContext()).also {
            it.flexDirection = FlexDirection.ROW
            it.flexWrap = FlexWrap.WRAP
            it.justifyContent = JustifyContent.SPACE_EVENLY
        }

        homeViewModel.sponsors.observe(viewLifecycleOwner, Observer { sponsors ->
            sponsors?.let {
                val goldSponsors = mutableListOf<Sponsor>()
                val otherSponsors = mutableListOf<Sponsor>()

                sponsors.forEach { if (it.isGold) goldSponsors.add(it) else otherSponsors.add(it) }

                goldAdapter.submitList(goldSponsors)
                otherAdapter.submitList(otherSponsors)
            }
        })
        homeViewModel.retrieveSponsors()
    }

    private fun showOrganizers() {

        val adapter = OrganizerAdapter()
        binding.organizersList.adapter = adapter

        homeViewModel.organizerList.observe(viewLifecycleOwner, Observer { organizers ->
            if (organizers == null) {
                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                adapter.updateData(organizers)
            }
        })

        homeViewModel.retrieveOrganizerList()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}