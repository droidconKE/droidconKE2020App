package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.android254.droidconKE2020.home.R
import com.android254.droidconKE2020.home.domain.Sponsor
import com.android254.droidconKE2020.home.utlities.CommonTasks.launchBrowser

class GoldSponsorAdapter : ListAdapter<Sponsor, RecyclerView.ViewHolder>(SponsorDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_gold_sponsor, parent, false)
        return SponsorViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sponsor = getItem(position)
        (holder as SponsorViewHolder).bind(sponsor)
    }


    class SponsorViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        private val imgSponsor: AppCompatImageView = view.findViewById(R.id.imgSponsor)

        fun bind(item: Sponsor) {
            imgSponsor.also {
                it.load(item.imageUrl)
                it.setOnClickListener { launchBrowser(item.website, view.context) }
            }
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