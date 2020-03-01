package com.android254.droidconKE2020.feed.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android254.droidconKE2020.feed.R
import com.android254.droidconKE2020.feed.databinding.FragmentFeedBinding

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

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
        val listener = object : Listener {
            override fun onShareClicked(feed: Feed) {
                // TODO Handle share logic
                Toast.makeText(context!!, "Share button clicked.", Toast.LENGTH_SHORT).show()
            }
        }
        val adapter = FeedAdapter(listener)
        binding.feedsList.adapter = adapter
        adapter.updateData(createDummyData()) // TODO Remove use of dummy data
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun createDummyData(): List<Feed> {
        val list = mutableListOf<Feed>()
        for (i in 0 until 10) {
            list.add(Feed(content = context!!.getString(R.string.dummy_text), time = "10:5$i"))
        }
        return list
    }

}