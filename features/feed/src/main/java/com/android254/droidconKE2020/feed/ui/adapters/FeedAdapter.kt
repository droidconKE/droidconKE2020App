package com.android254.droidconKE2020.feed.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.android254.droidconKE2020.core.models.FeedUIModel
import com.android254.droidconKE2020.feed.databinding.ItemFeedsBinding
import com.android254.droidconKE2020.feed.utils.DiffUtilCallBack

class FeedAdapter(private val onSharedClicked: (FeedUIModel) -> Unit) :
    PagingDataAdapter<FeedUIModel, FeedAdapter.FeedViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFeedsBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        getItem(position)?.let { holder.bindFeed(it) }
    }

    inner class FeedViewHolder(private val binding: ItemFeedsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindFeed(feed: FeedUIModel) {
            with(feed) {
                binding.content.text = content
                binding.image.load(imageUrl) {
                    transformations(RoundedCornersTransformation(12f))
                }
                binding.time.text = time
                binding.shareBtn.setOnClickListener {
                    onSharedClicked.invoke(this)
                }
            }
            feed.let {
            }
        }
    }
}