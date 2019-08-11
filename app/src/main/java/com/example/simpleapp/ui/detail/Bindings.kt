package com.example.simpleapp.ui.detail

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.data.entity.Post


/**
 * [BindingAdapter]s for the [Post]s list.
 */
@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Post>) {
    (listView.adapter as PostsAdapter).submitList(items)
}