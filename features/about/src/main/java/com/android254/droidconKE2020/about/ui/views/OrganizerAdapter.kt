package com.android254.droidconKE2020.about.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.about.databinding.ItemOrganizerBinding
import com.android254.droidconKE2020.about.ui.viewmodel.OrganizerViewModel
import kotlinx.android.synthetic.main.item_organizer.view.*

typealias ClickListener =(Organizer) -> Unit
class OrganizerAdapter(private val clickListener : ClickListener) :

    RecyclerView.Adapter<OrganizerAdapter.OrganizerViewHolder>() {

    private val organizers = mutableListOf<Organizer>()
    private lateinit var binding: ItemOrganizerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        binding = ItemOrganizerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizerViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int = organizers.size

    override fun onBindViewHolder(holder: OrganizerViewHolder, position: Int) {
        val organizer = organizers[position]
        holder.bindOrganizer(organizer)
    }

    fun updateData(list: List<Organizer>) {
        organizers.clear()
        organizers.addAll(list)
        notifyDataSetChanged()
    }

    inner class OrganizerViewHolder(binding: ItemOrganizerBinding, clickListener : ClickListener) : RecyclerView.ViewHolder(binding.root) {
        private val organizerViewModel = OrganizerViewModel()

        fun bindOrganizer(organizer: Organizer) {
            with(organizer) {
                organizerViewModel.bind(organizer)
                binding.organizerViewModel = organizerViewModel
                itemView.setOnClickListener {
                    clickListener(this)
                }
            }
        }
    }
}