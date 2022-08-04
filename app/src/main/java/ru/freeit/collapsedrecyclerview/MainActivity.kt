package ru.freeit.collapsedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.collapsedrecyclerview.adapter.TextItemsAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val adapter = TextItemsAdapter()
        recyclerView.adapter = adapter

        adapter.changeClickListener { header ->
            adapter.submitList(viewModel.expandSomeElements(adapter.currentList, viewModel.value(), header))
        }

        viewModel.observe(this) { items ->
            adapter.submitList(viewModel.expandSomeElements(allItems = items))
        }

    }

}