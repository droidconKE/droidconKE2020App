package com.android254.droidconKE2020.feed.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.android254.droidconKE2020.core.utils.toast
import com.android254.droidconKE2020.feed.databinding.FragmentFeedBinding
import com.android254.droidconKE2020.feed.di.feedModule
import com.android254.droidconKE2020.feed.ui.adapters.FeedAdapter
import com.android254.droidconKE2020.feed.ui.adapters.FeedsLoadingAdapter
import com.android254.droidconKE2020.feed.ui.viewmodels.FeedViewModel
import com.android254.droidconKE2020.repository.repoModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(listOf(feedModule, repoModule)) }
private fun injectFeature() = loadFeature

class FeedFragment : Fragment() {
    private val viewModel: FeedViewModel by viewModel()
    lateinit var feedAdapter: FeedAdapter
    private var _binding: FragmentFeedBinding? = null
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
        initAdapter()
        getFeeds()

        viewModel.getFeeds().observe(viewLifecycleOwner) { pagingData ->
            lifecycleScope.launchWhenStarted {
                feedAdapter.submitData(pagingData)
            }
        }
    }

    private fun initAdapter() {
        feedAdapter = FeedAdapter {
            findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToShareFragment())
        }
        binding.feedsList.adapter = feedAdapter
        binding.feedsList.adapter = feedAdapter.withLoadStateFooter(
            footer = FeedsLoadingAdapter { feedAdapter.retry() }
        )
        feedAdapter.addLoadStateListener { loadState ->
            binding.feedsList.isVisible = loadState.refresh is LoadState.NotLoading
            binding.noFeeds.isVisible = loadState.refresh is LoadState.Error
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

    private fun getFeeds() {
        viewModel.getFeeds()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}