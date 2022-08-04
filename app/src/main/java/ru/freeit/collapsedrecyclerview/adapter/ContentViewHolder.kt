package ru.freeit.collapsedrecyclerview.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.collapsedrecyclerview.data.Item
import ru.freeit.collapsedrecyclerview.R
import ru.freeit.collapsedrecyclerview.core.inflateView

class ContentViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflateView(R.layout.content_list_item)) {
    fun bind(content: Item.TextItem) {
        content.bind(itemView as TextView)
    }
}