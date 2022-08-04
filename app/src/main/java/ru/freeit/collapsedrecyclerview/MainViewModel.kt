package ru.freeit.collapsedrecyclerview

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.freeit.collapsedrecyclerview.data.Item

class MainViewModel : ViewModel() {

    private val items = MutableLiveData<List<Item>>()

    fun value() = items.value ?: listOf()

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<Item>>) = items.observe(lifecycleOwner, observer)

    init {
        items.value = listOf(
            Item.HeaderItem("Title 1"),
            Item.TextItem("Description 1"),
            Item.TextItem("Description 2"),
            Item.TextItem("Description 3"),
            Item.HeaderItem("Title 2"),
            Item.TextItem("Description 4"),
            Item.TextItem("Description 5"),
            Item.TextItem("Description 6"),
        )
    }

    fun expandSomeElements(currentList: List<Item> = listOf(), allItems: List<Item>, clickedHeader: Item.HeaderItem? = null) : List<Item> {

        val expandedHeaderIndex = if (clickedHeader != null) {
            val clickedHeaderIndexInCurrentList = currentList.indexOf(clickedHeader)
            val isExpanded = currentList.getOrNull(clickedHeaderIndexInCurrentList + 1) is Item.TextItem

            if (isExpanded) -1 else allItems.indexOf(clickedHeader)
        } else {
            -1
        }

        val newList = mutableListOf<Item>()

        var currentIndex = 0
        var isAfterSelectedHeader = false
        while (currentIndex < allItems.size) {
            val currentItem = allItems[currentIndex]
            if (currentItem is Item.HeaderItem) {
                isAfterSelectedHeader = currentIndex == expandedHeaderIndex
                newList.add(currentItem)
            } else if (isAfterSelectedHeader) {
                newList.add(currentItem)
            }
            currentIndex++
        }

        return newList
    }


}