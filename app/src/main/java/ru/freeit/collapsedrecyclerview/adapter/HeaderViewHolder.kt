package ru.freeit.collapsedrecyclerview.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.collapsedrecyclerview.data.Item
import ru.freeit.collapsedrecyclerview.R
import ru.freeit.collapsedrecyclerview.core.inflateView

class HeaderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflateView(R.layout.header_list_item)) {
    fun bind(header: Item.HeaderItem, clickListener: (item: Item.HeaderItem) -> Unit) {
        header.bind(itemView as TextView)
        itemView.setOnClickListener {
            clickListener.invoke(header)
        }
    }
}