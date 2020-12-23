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
import coil.load
import com.android254.droidconKE2020.core.di.browserModule
import com.android254.droidconKE2020.core.models.SessionUIModel
import com.android254.droidconKE2020.core.models.SpeakerUIModel
import com.android254.droidconKE2020.core.models.SponsorUIModel
import com.android254.droidconKE2020.core.utils.WebPages
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.databinding.FragmentHomeBinding
import com.android254.droidconKE2020.home.di.homeModule
import com.android254.droidconKE2020.home.ui.adapters.*
import com.android254.droidconKE2020.home.ui.viewmodel.HomeViewModel
import com.android254.droidconKE2020.home.utils.EmailConstants
import com.android254.droidconKE2020.repository.repoModule
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
    loadKoinModules(listOf(homeModule, browserModule, repoModule))
}

class HomeFragment : Fragment(R.layout.fragment_home) {
    private fun injectFeature() = loadFeature
    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sessionsAdapter = SessionAdapter {
        onSessionClicked(it)
    }
    private val organizerAdapter = OrganizerAdapter()
    private val speakerAdapter = SpeakerAdapter {
        onSpeakerClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPromoCard()
        showCallForSpeakersCard()
        showSessionsList()
        showSpeakers()
        showSponsors()
        showOrganizers()
        showError()
        homeViewModel.loadData()
    }

    private fun showError() {
        homeViewModel.showToast.observe(viewLifecycleOwner) { errorMesage ->
            requireContext().toast(errorMesage)
        }
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

    private fun onSpeakerClicked(speakerUIModel: SpeakerUIModel) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToSpeakerDetailsFragment(
                speakerUIModel
            )
        )
    }

    private fun launchBrowser(webUrl: String) {
        val webPages: WebPages by inject()
        webPages.launchInAppBrowser(webUrl)
    }

    private fun sendEmail(addresses: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            type = "message/rfc822"
            val uriText = "mailto:$addresses?subject=$subject"
            data = Uri.parse(uriText)
        }
        if (intent.resolveActivity(requireContext().packageManager) != null) startActivity(intent)
    }

    private fun showPromoCard() {
        // Check for any available promos
        homeViewModel.activePromo.observe(
            viewLifecycleOwner,
            Observer { promo ->
                binding.promoImg.visibility = if (promo != null) View.VISIBLE else View.GONE
                promo?.let {
                    binding.promoImg.load(promo.imageUrl.toInt()) // ToDo: Remove the int cast upon introducing real data
                    binding.promoImg.setOnClickListener { launchBrowser(promo.webUrl) }
                }
            }
        )

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

    private fun showSessionsList() {
        binding.viewSessionsBtn.setOnClickListener { viewAllSessionsClicked() }
        binding.sessionsList.adapter = sessionsAdapter
        binding.sessionsList.addItemDecoration(HorizontalSpaceDecoration(30))
        homeViewModel.sessions.observe(viewLifecycleOwner) { sessions ->
            sessionsAdapter.submitList(sessions)
            if (sessions.isEmpty()) {
                binding.sessionCountChip.visibility = View.GONE
            } else {
                binding.sessionCountChip.visibility = View.VISIBLE
                val totalSessions = "+${sessions.size}"
                binding.sessionCountChip.text = totalSessions
            }
        }
    }

    private fun showSpeakers() {
        homeViewModel.speakers.observe(viewLifecycleOwner) { speakers ->
            speakerAdapter.submitList(speakers)
            if (speakers.isEmpty()) {
                binding.speakersCountChip.visibility = View.GONE
            } else {
                binding.speakersCountChip.visibility = View.VISIBLE
                val totalSpeakers = "+${speakers.size}"
                binding.speakersCountChip.text = totalSpeakers
            }
        }
        homeViewModel.keynoteSpeaker.observe(viewLifecycleOwner) { keynoteSpeaker ->
            binding.keynoteSpeakerImg.also {
                it.load(keynoteSpeaker.speakerAvatar)
                it.setOnClickListener { onSpeakerClicked(keynoteSpeaker) }
            }
            binding.keynoteSpeakerLbl.also {
                it.text = keynoteSpeaker.speakerName
                it.setOnClickListener { onSpeakerClicked(keynoteSpeaker) }
            }
            binding.keynoteLblBecomeSpeaker.setOnClickListener {
                launchBrowser(homeViewModel.callForSpeakerUrl)
            }
        }
        binding.speakersList.adapter = speakerAdapter
        binding.speakersList.addItemDecoration(HorizontalSpaceDecoration(30))
        binding.viewSpeakersBtn.setOnClickListener { viewAllSpeakersClicked() }
    }

    private fun showSponsors() {
        binding.tvBecomeSponsor.setOnClickListener {
            sendEmail(EmailConstants.SPONSORSHIP_EMAIL, EmailConstants.SPONSORSHIP_SUBJECT)
        }
        val onSponsorClicked: (SponsorUIModel) -> Unit = { launchBrowser(it.link) }
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
        homeViewModel.sponsors.observe(viewLifecycleOwner) { sponsors ->
            goldAdapter.submitList(sponsors)
            otherAdapter.submitList(sponsors)
        }
    }

    private fun showOrganizers() {
        binding.organizersList.adapter = organizerAdapter
        homeViewModel.organizers.observe(viewLifecycleOwner) { organizers ->
            organizerAdapter.submitList(organizers.filter { it.organizerType == "company" })
        }
    }

    private fun onSessionClicked(sessionUIModel: SessionUIModel) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSessionDetailsFragment(sessionUIModel))
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}