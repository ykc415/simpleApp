package com.example.simpleapp.util

import androidx.paging.PagedList

inline fun <T> PagedList<T>.withSnapshot(crossinline listener: (list: PagedListWithSnapshot<T>) -> Unit): PagedListWithSnapshot<T> {
    this.addWeakCallback(null, object : PagedList.Callback() {
        override fun onChanged(position: Int, count: Int) {
            listener(PagedListWithSnapshot(this@withSnapshot))
        }

        override fun onInserted(position: Int, count: Int) {
            listener(PagedListWithSnapshot(this@withSnapshot))
        }

        override fun onRemoved(position: Int, count: Int) {
            listener(PagedListWithSnapshot(this@withSnapshot))
        }
    })

    return PagedListWithSnapshot(this)
}

class PagedListWithSnapshot<T>(val pagedList: PagedList<T>) {
    private val snapshot = pagedList.snapshot()


    override fun hashCode(): Int {
        return snapshot.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other === this)
            return true
        return if (other !is PagedListWithSnapshot<*>) false else snapshot == other.snapshot
    }
}