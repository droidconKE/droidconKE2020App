package com.android254.droidconKE2020.speakers.ui.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.android254.droidconKE2020.core.utils.hideKeyboard
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.repository.repoModule
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBinding
import com.android254.droidconKE2020.speakers.di.speakersModule
import com.android254.droidconKE2020.speakers.ui.adapters.SpeakersAdapter
import com.android254.droidconKE2020.speakers.ui.adapters.SpeakersLoadingAdapter
import com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(speakersModule, repoModule)) }
private fun injectFeature() = loadFeature

class SpeakersFragment : Fragment() {
    private val speakersViewModel: SpeakersViewModel by viewModel()
    lateinit var speakersAdapter: SpeakersAdapter
    private var _binding: FragmentSpeakersBinding? = null
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
        _binding = FragmentSpeakersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.speakersViewModel = speakersViewModel
        binding.lifecycleOwner = this
        binding.setGoBack { findNavController().navigateUp() }
        binding.setClearSearch { view1 ->
            view1.hideKeyboard()
            binding.tvSearch.setText("")
            binding.tvSearch.clearFocus()
        }
        binding.setOpenProfile {
            findNavController().navigate(com.android254.droidconKE2020.R.id.authDialog)
        }
        binding.tvSearch.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    speakersViewModel.searchTerm.value = s?.toString() ?: ""
                }

                override fun afterTextChanged(s: Editable?) {
                }
            }
        )

        initAdapter()

        speakersViewModel.getSpeakers().observe(viewLifecycleOwner) { pagingData ->
            lifecycleScope.launchWhenStarted {
                speakersAdapter.submitData(pagingData)
            }
        }
    }

    private fun initAdapter() {
        speakersAdapter = SpeakersAdapter { speaker ->
            findNavController().navigate(
                SpeakersFragmentDirections.actionSpeakersFragmentToSpeakerDetailsFragment(
                    speaker
                )
            )
        }
        binding.rvSpeakers.adapter = speakersAdapter.withLoadStateFooter(
            footer = SpeakersLoadingAdapter { speakersAdapter.retry() }
        )
        speakersAdapter.addLoadStateListener { loadState ->
            binding.rvSpeakers.isVisible = loadState.refresh is LoadState.NotLoading
            binding.noSpeakers.isVisible = loadState.refresh is LoadState.Error
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading

            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error
            errorState?.let {
                requireContext().toast("Wooops ${it.error}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}