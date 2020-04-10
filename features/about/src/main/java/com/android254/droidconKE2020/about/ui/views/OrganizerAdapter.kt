package com.android254.droidconKE2020.about.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android254.droidconKE2020.about.databinding.ItemOrganizerBinding
import kotlinx.android.synthetic.main.item_organizer.view.*

typealias ClickListener =(Organizer) -> Unit
class OrganizerAdapter(private val clickListener : ClickListener) :

    RecyclerView.Adapter<OrganizerAdapter.OrganizerViewHolder>() {

    private val organizers = mutableListOf<Organizer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        val binding = ItemOrganizerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizerViewHolder(binding.root, clickListener)
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

    inner class OrganizerViewHolder(view: View, clickListener : ClickListener) : RecyclerView.ViewHolder(view) {
        val organizerImg: ImageView = view.img_organizer
        val nametxt: TextView =  view.organizer_name
        val titletxt: TextView = view.organizer_title

        fun bindOrganizer(organizer: Organizer) {
            with(organizer) {
                nametxt.text = name
                titletxt.text = title
                itemView.setOnClickListener {
                    clickListener(this)
                }
            }
        }
    }
}