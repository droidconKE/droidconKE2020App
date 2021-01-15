package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android254.droidconKE2020.core.models.SponsorUIModel
import com.android254.droidconKE2020.home.R

class OtherSponsorAdapter(private var onSponsorClickedEvent: (SponsorUIModel) -> Unit) :
    ListAdapter<SponsorUIModel, RecyclerView.ViewHolder>(SponsorDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_other_sponsor, parent, false)
        return SponsorViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sponsor = getItem(position)
        (holder as SponsorViewHolder).bind(sponsor)
    }

    inner class SponsorViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val imgSponsor: AppCompatImageView = view.findViewById(R.id.imgSponsor)

        fun bind(item: SponsorUIModel) {
            imgSponsor.also {
                it.load(item.logo)
                it.setOnClickListener { onSponsorClickedEvent.invoke(item) }
            }
        }
    }

    class SponsorDiffCallback : DiffUtil.ItemCallback<SponsorUIModel>() {

        override fun areItemsTheSame(oldItem: SponsorUIModel, newItem: SponsorUIModel): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: SponsorUIModel, newItem: SponsorUIModel): Boolean =
            oldItem == newItem
    }
}