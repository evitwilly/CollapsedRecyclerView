package ru.freeit.collapsedrecyclerview.data

import android.widget.TextView

sealed interface Item {

    data class HeaderItem(private val text: String) : Item {
        fun bind(view: TextView) {
            view.text = text
        }
    }

    data class TextItem(private val content: String) : Item {
        fun bind(view: TextView) {
            view.text = content
        }
    }

}