package com.codersguidebook.names

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NamesAdapter : Adapter<ViewHolder>() {
    val names = listOf<String>()

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