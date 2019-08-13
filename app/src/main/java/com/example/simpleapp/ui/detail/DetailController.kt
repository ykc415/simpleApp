package com.example.simpleapp.ui.detail

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.simpleapp.BuildConfig
import com.example.simpleapp.comment
import com.example.simpleapp.commentHeader
import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post

class DetailController : Typed2EpoxyController<Post, List<Comment>>() {

    init {
        setFilterDuplicates(true)

        if (BuildConfig.DEBUG) {
            isDebugLoggingEnabled = true
        }
    }

    override fun buildModels(post: Post?, comments: List<Comment>?) {
        commentHeader {
            id(post?.id)
            post(post)
        }

        comments?.forEach { comment ->
            comment {
                id(comment.id)
                comment(comment)
            }
        }
    }
}