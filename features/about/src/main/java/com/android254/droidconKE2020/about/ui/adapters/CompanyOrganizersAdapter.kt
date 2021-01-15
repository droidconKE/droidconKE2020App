package com.android254.droidconKE2020.about.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.about.databinding.ItemCompanyOrganizerBinding
import com.android254.droidconKE2020.core.diffutils.OrganizersDiffUtilsCallback
import com.android254.droidconKE2020.core.models.OrganizerUIModel

class CompanyOrganizersAdapter : ListAdapter<OrganizerUIModel, CompanyOrganizersAdapter.CompanyOrganizerViewHolder>(
    OrganizersDiffUtilsCallback()
) {

    class CompanyOrganizerViewHolder(private val binding: ItemCompanyOrganizerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindOrganizer(organizer: OrganizerUIModel) {
            with(organizer) {
                binding.organizerUIModel = this
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyOrganizerViewHolder {
        val binding = ItemCompanyOrganizerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyOrganizerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompanyOrganizerViewHolder, position: Int) {
        holder.bindOrganizer(getItem(position))
    }
}