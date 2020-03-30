package com.android254.droidconKE2020.feed.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android254.droidconKE2020.feed.R
import com.android254.droidconKE2020.feed.databinding.FragmentFeedBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(feedModule) }
private fun injectFeature() = loadFeature

val navController: (fragment: Fragment) -> NavController = {
    NavHostFragment.findNavController(it)
}


class FeedFragment : Fragment(R.layout.fragment_feed) {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val onSharedClicked: (Feed) -> Unit = {
            // TODO Handle share logic
            navController(this).navigate(FeedFragmentDirections.actionFeedFragmentToShareFragment())
        }
        val adapter = FeedAdapter(onSharedClicked)
        binding.feedsList.adapter = adapter
        viewModel.feeds.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}