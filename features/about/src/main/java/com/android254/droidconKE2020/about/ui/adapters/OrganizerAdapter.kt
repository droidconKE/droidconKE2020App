package com.android254.droidconKE2020.about.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.about.databinding.ItemOrganizerBinding
import com.android254.droidconKE2020.core.diffutils.OrganizersDiffUtilsCallback
import com.android254.droidconKE2020.core.models.OrganizerUIModel

typealias ClickListener = (OrganizerUIModel) -> Unit

class OrganizerAdapter(private val clickListener: ClickListener) :
    ListAdapter<OrganizerUIModel, OrganizerAdapter.OrganizerViewHolder>(OrganizersDiffUtilsCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        val binding = ItemOrganizerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizerViewHolder(binding, clickListener)
    }
    override fun onBindViewHolder(holder: OrganizerViewHolder, position: Int) {
        holder.bindOrganizer(getItem(position))
    }

    inner class OrganizerViewHolder(private val binding: ItemOrganizerBinding, clickListener: ClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindOrganizer(organizer: OrganizerUIModel) {
            with(organizer) {
                binding.organizerUIModel = this
                itemView.setOnClickListener {
                    clickListener(this)
                }
            }
        }
    }
}