package com.android254.droidconKE2020.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.core.diffutils.OrganizersDiffUtilsCallback
import com.android254.droidconKE2020.core.models.OrganizerUIModel
import com.android254.droidconKE2020.home.databinding.HomeItemOrganizerBinding
import kotlinx.android.synthetic.main.home_item_organizer.view.*

class OrganizerAdapter : ListAdapter<OrganizerUIModel, OrganizerAdapter.OrganizerViewHolder>(
    OrganizersDiffUtilsCallback()
) {

    class OrganizerViewHolder(private val binding: HomeItemOrganizerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindOrganizer(organizer: OrganizerUIModel) {
            with(organizer) {
                binding.organizerUIModel = this
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        val binding = HomeItemOrganizerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrganizerViewHolder, position: Int) {
        holder.bindOrganizer(getItem(position))
    }
}