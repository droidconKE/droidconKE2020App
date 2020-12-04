package com.android254.droidconKE2020.speakers.ui.views

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.viewmodels.SpeakerDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(speakersModule) }
private fun injectFeature() = loadFeature

class SpeakerDetailsFragment : Fragment() {
    private var _binding: FragmentSpeakerDetailsBinding? = null
    private val binding get() = _binding!!
    private val speakerDetailsViewModel: SpeakerDetailsViewModel by viewModel()
    private val args: SpeakerDetailsFragmentArgs by navArgs()

    private var callback: OnBackPressedCallback? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()

        callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            isEnabled = true
            findNavController().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpeakerDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = speakerDetailsViewModel

        binding.btnNavBack.setOnClickListener {
            callback!!.handleOnBackPressed()
        }
        binding.copyIcon.setOnClickListener {
            copyTwitterHandle()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSpeaker()
    }

    private fun loadSpeaker() {
        binding.speaker = args.speaker
    }

    private fun copyTwitterHandle() {
        val clipboard =
            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(
            "twitter handle",
            speakerDetailsViewModel.getHandleFromUrl(args.speaker.speakerTwitterProfile)
        )
        clipboard.setPrimaryClip(clip)
        requireContext().toast("Twitter handle copied.")
    }
}