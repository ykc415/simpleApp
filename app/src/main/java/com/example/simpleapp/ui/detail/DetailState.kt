package com.example.simpleapp.ui.detail

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post

data class DetailState(
    val post: Post,
    val comments: Async<List<Comment>> = Uninitialized
) : MvRxState