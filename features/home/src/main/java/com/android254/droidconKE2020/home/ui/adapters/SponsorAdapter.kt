package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.home.databinding.HomeItemSponsorBinding
import com.android254.droidconKE2020.home.domain.Sponsor
import com.android254.droidconKE2020.home.utlities.CommonTasks.launchBrowser

class SponsorAdapter : ListAdapter<Sponsor, RecyclerView.ViewHolder>(SponsorDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            HomeItemSponsorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SponsorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sponsor = getItem(position)
        (holder as SponsorViewHolder).bind(sponsor)
    }

    class SponsorViewHolder(private val binding: HomeItemSponsorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setOpenSponsorWebsite {
                launchBrowser(binding.sponsor.imageUrl, binding.root.context)
            }
        }

        fun bind(item: Sponsor) {
            binding.apply { sponsor = item;executePendingBindings() }
        }
    }

    class SponsorDiffCallback : DiffUtil.ItemCallback<Sponsor>() {

        override fun areItemsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem == newItem
        }
    }
}