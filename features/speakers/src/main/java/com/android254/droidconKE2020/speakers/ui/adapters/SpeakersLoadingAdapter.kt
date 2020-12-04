package com.android254.droidconKE2020.speakers.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.speaker.databinding.ItemSpeakerLoadingStateBinding

class SpeakersLoadingAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<SpeakersLoadingAdapter.SpeakerLoadingViewHolder>() {

    class SpeakerLoadingViewHolder(
        private val binding: ItemSpeakerLoadingStateBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.tvErrorMessage.text = loadState.error.localizedMessage
            }
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.tvErrorMessage.isVisible = loadState !is LoadState.Loading
            binding.btnRetry.isVisible = loadState !is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: SpeakerLoadingViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): SpeakerLoadingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSpeakerLoadingStateBinding.inflate(inflater, parent, false)
        return SpeakerLoadingViewHolder(binding, retry)
    }
}