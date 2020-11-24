package com.android254.droidconKE2020.feed.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.android254.droidconKE2020.feed.R
import com.android254.droidconKE2020.feed.databinding.FragmentFeedBinding
import com.android254.droidconKE2020.feed.di.feedModule
import com.android254.droidconKE2020.feed.ui.adapters.FeedAdapter
import com.android254.droidconKE2020.feed.ui.viewmodels.FeedViewModel
import com.android254.droidconKE2020.repository.repoModule
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(feedModule, repoModule)) }
private fun injectFeature() = loadFeature

class FeedFragment : Fragment() {
    private val viewModel: FeedViewModel by viewModel()
    lateinit var feedAdapter: FeedAdapter
    private var _binding : FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        feedAdapter = FeedAdapter {
            findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToShareFragment())
        }
        binding.feedsList.adapter = feedAdapter
        getFeeds()

        viewModel.getFeeds().observe(viewLifecycleOwner) { pagingData ->
            lifecycleScope.launchWhenStarted {
                feedAdapter.submitData(pagingData)
            }
        }
    }

    private fun getFeeds() {
        viewModel.getFeeds()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}