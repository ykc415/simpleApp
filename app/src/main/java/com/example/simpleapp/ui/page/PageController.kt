package com.example.simpleapp.ui.page

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.simpleapp.BuildConfig
import com.example.simpleapp.PostBindingModel_
import com.example.simpleapp.data.entity.Post

class PageController(private val postCallback: PostCallback) : PagedListEpoxyController<Post>() {

    init {
        setFilterDuplicates(true)

        if (BuildConfig.DEBUG) {
            isDebugLoggingEnabled = true
        }
    }

    interface PostCallback {
        fun onPostClick(post: Post)
    }

    override fun buildItemModel(currentPosition: Int, item: Post?): EpoxyModel<*> {
        return if (item != null) {
            PostBindingModel_()
                .id(currentPosition)
                .post(item)
                .onClick { v ->
                    postCallback.onPostClick(item)
                }
        } else {
            PostBindingModel_()
                .id(-1)
        }
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        throw exception
    }
}
