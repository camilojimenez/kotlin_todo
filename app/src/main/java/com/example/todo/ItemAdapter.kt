package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    private val dataset: MutableList<String>,
    private val onDelete: (position: Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // This is the view Holder
    class ItemViewHolder(
        private val view: View,
        private val onDelete: (position: Int) -> Unit,
        private val adapter: ItemAdapter
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textView: TextView = view.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View){
            onDelete(this.layoutPosition)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout, onDelete, this)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item
    }

    override fun getItemCount() = dataset.size

}