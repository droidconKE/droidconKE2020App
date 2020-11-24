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
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(feedModule) }
private fun injectFeature() = loadFeature

val navController: (fragment: Fragment) -> NavController = {
    NavHostFragment.findNavController(it)
}

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModel()
    lateinit var feedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_feed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFeedBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        feedAdapter = FeedAdapter {
            findNavController().navigate(R.id.action_feedFragment_to_shareFragment)
        }
        binding.feedsList.adapter = feedAdapter
        getFeeds()

        viewModel.feeds.observe(viewLifecycleOwner){pagingData ->
            lifecycleScope.launchWhenStarted {
                feedAdapter.submitData(pagingData)
            }
        }

    }

    private fun getFeeds() {
        viewModel.getFeeds()
    }
}