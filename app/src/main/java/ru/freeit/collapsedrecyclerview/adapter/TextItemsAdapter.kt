package ru.freeit.collapsedrecyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.collapsedrecyclerview.data.Item

class TextItemsAdapter: ListAdapter<Item, RecyclerView.ViewHolder>(object: DiffUtil.ItemCallback<Item>() {
    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
}) {

    private var clickListener: (item: Item.HeaderItem) -> Unit = {}

    fun changeClickListener(listener: (item: Item.HeaderItem) -> Unit) {
        clickListener = listener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(getItem(position) as Item.HeaderItem, clickListener)
            is ContentViewHolder -> holder.bind(getItem(position) as Item.TextItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            header -> HeaderViewHolder(parent)
            else -> ContentViewHolder(parent)
        }

    override fun getItemViewType(position: Int): Int =
        when(getItem(position)) {
            is Item.HeaderItem -> header
            else -> content
        }


    private companion object {
        const val header = 1
        const val content = 2
    }
}