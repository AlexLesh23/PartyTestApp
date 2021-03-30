package com.bsc.msc.testapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bsc.msc.testapp.R
import com.bsc.msc.testapp.model.*
import com.bumptech.glide.Glide

class GuestsRecyclerViewAdapter(
    var models: List<ViewItem>,
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_ITEM
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_guest_header, parent, false)
            )
            VIEW_TYPE_ITEM -> GuestViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_guest, parent, false)
            )
            else -> throw IllegalArgumentException("Unexpected view type: $viewType")
        }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GuestViewHolder) {
            holder.configure(models[position] as GuestViewItem, context)
        } else if (holder is HeaderViewHolder) {
            holder.configure(models[position] as HeaderViewItem, context)
        }
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }
}


class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val partyNameTextView: TextView = itemView.findViewById(R.id.partyNameTextView)
    private val partyImageView: ImageView = itemView.findViewById(R.id.partyImageView)
    private val inviterAvatarImageView: ImageView =
        itemView.findViewById(R.id.inviterAvatarImageView)
    private val inviterNameTextView: TextView = itemView.findViewById(R.id.inviterNameTextView)

    fun configure(model: HeaderViewItem, context: Context) {
        partyNameTextView.text = model.partyName
        inviterNameTextView.text = model.inviterName
        Glide.with(context)
            .load(model.partyImageURL)
            .into(partyImageView)
        Glide.with(context)
            .load(model.inviterAvatarURL)
            .placeholder(R.drawable.ic_placeholder)
            .circleCrop()
            .into(inviterAvatarImageView)
    }

}

class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val guestNameTextView: TextView = itemView.findViewById(R.id.guestNameTextView)
    private val guestAvatarImageView: ImageView = itemView.findViewById(R.id.guestAvatarImageView)

    fun configure(model: GuestViewItem, context: Context) {
        guestNameTextView.text = model.name
        Glide.with(context).load(model.avatar).placeholder(R.drawable.ic_placeholder).circleCrop()
            .into(guestAvatarImageView)
    }
}