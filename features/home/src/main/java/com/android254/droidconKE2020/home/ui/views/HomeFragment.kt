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
import com.android254.droidconKE2020.home.di.homeRepositories
import com.android254.droidconKE2020.home.di.homeViewModels
import com.android254.droidconKE2020.home.domain.Sponsor
import com.android254.droidconKE2020.home.ui.adapters.*
import com.android254.droidconKE2020.home.viewmodel.HomeViewModel
import com.android254.droidconKE2020.speakers.models.Speaker
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy {
    loadKoinModules(listOf(homeViewModels, homeRepositories, browserModule))
}

class HomeFragment : Fragment() {
    private fun injectFeature() = loadFeature

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
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

    private fun onSpeakerClicked(speakerId: Int) {
        val speakerDetailsAction =
            HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment(speakerId)
        findNavController().navigate(speakerDetailsAction)
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
            promoImg.visibility = if (promo != null) View.VISIBLE else View.GONE
            promo?.let {
                promoImg.load(promo.imageUrl.toInt()) // ToDo: Remove the int cast upon introducing real data
                promoImg.setOnClickListener { launchBrowser(promo.webUrl) }
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
        applyBtn.setOnClickListener { launchBrowser(callForSpeakerUrl) }
        cfpDescription.setOnClickListener { launchBrowser(callForSpeakerUrl) }
        cfpImage.load(R.drawable.cfp_image)
    }

    private fun showKeynoteInfoCard() {
        homeViewModel.retrieveSpeakerList()

        homeViewModel.keynoteSpeaker.observe(viewLifecycleOwner, Observer { keynoteSpeaker ->
            if (keynoteSpeaker == null) {
                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                keynoteSpeakerImg.also {
                    it.load(keynoteSpeaker.imageUrl)
                    it.setOnClickListener { onSpeakerClicked(keynoteSpeaker.id) }
                }
                keynoteSpeakerLbl.also {
                    it.text = keynoteSpeaker.name
                    it.setOnClickListener { onSpeakerClicked(keynoteSpeaker.id) }
                }
                keynoteLblBecomeSpeaker.setOnClickListener {
                    launchBrowser(homeViewModel.callForSpeakerUrl)
                }
            }
        })
    }

    private fun showSessionsList() {
        sessionCountChip.setOnClickListener { viewSessionsBtn.callOnClick() }
        viewSessionsBtn.setOnClickListener {
            val sessionsFragmentAction =
                HomeFragmentDirections.actionHomeFragmentToSessionsFragment()
            findNavController().navigate(sessionsFragmentAction)
        }

        val adapter = SessionAdapter()
        sessionsList.adapter = adapter

        homeViewModel.sessionList.observe(viewLifecycleOwner, Observer { sessions ->
            if (sessions == null) {
                sessionCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                sessionCountChip.visibility = View.VISIBLE
                val totalSessions = "+${sessions.size}"
                sessionCountChip.text = totalSessions
                adapter.updateData(sessions)
            }
        })

        homeViewModel.retrieveSessionList()
    }

    private fun showSpeakersList() {
        speakersCountChip.setOnClickListener { viewSpeakersBtn.callOnClick() }
        viewSpeakersBtn.setOnClickListener {
            val speakersFragmentAction =
                HomeFragmentDirections.actionHomeFragmentToSpeakersFragment()
            findNavController().navigate(speakersFragmentAction)
        }

        val onSpeakerClicked: (Speaker) -> Unit = { onSpeakerClicked(it.id) }
        val adapter = SpeakerAdapter(onSpeakerClicked)
        speakersList.adapter = adapter

        homeViewModel.speakerList.observe(viewLifecycleOwner, Observer { speakers ->
            if (speakers == null) {
                speakersCountChip.visibility = View.GONE

                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                speakersCountChip.visibility = View.VISIBLE
                val totalSpeakers = "+${speakers.size}"
                speakersCountChip.text = totalSpeakers
                adapter.updateData(speakers)
            }
        })

        homeViewModel.retrieveSpeakerList()
    }

    private fun showSponsors() {
        tvBecomeSponsor.setOnClickListener {
            sendEmail(homeViewModel.becomeSponsorEmails, homeViewModel.becomeSponsorSubject)
        }

        val onSponsorClicked: (Sponsor) -> Unit = { launchBrowser(it.website) }

        // ToDo: Merge two adapters to use a single list using MergeAdapter
        val goldAdapter = GoldSponsorAdapter(onSponsorClicked)
        rvGoldSponsors.adapter = goldAdapter
        rvGoldSponsors.layoutManager = FlexboxLayoutManager(requireContext()).also {
            it.flexDirection = FlexDirection.ROW
            it.flexWrap = FlexWrap.WRAP
            it.justifyContent = JustifyContent.SPACE_EVENLY
        }

        val otherAdapter = OtherSponsorAdapter(onSponsorClicked)
        rvOtherSponsors.adapter = otherAdapter
        rvOtherSponsors.layoutManager = FlexboxLayoutManager(requireContext()).also {
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
        organizersList.adapter = adapter

        homeViewModel.organizerList.observe(viewLifecycleOwner, Observer { organizers ->
            if (organizers == null) {
                // ToDo: Show shimmer effect. No need to hide since this will always be available
            } else {
                adapter.updateData(organizers)
            }
        })

        homeViewModel.retrieveOrganizerList()
    }

}