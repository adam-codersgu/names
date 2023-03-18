package com.codersguidebook.names

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.codersguidebook.recyclerviewfastscroller.RecyclerViewScrollbar

class NamesAdapter : Adapter<ViewHolder>(), RecyclerViewScrollbar.ValueLabelListener {
    val names = listOf<String>()

    override fun getValueLabelText(position: Int): String {
        return names[position][0].uppercase()
    }

    inner class ViewHolderName(itemView: View) : ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolderName(LayoutInflater.from(parent.context).inflate(R.layout.name, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = names[position]
        (holder.itemView.rootView as TextView).text = name
    }

    override fun getItemCount(): Int = names.size
}