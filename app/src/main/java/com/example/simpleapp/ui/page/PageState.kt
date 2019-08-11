package com.example.simpleapp.ui.page

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.simpleapp.data.entity.Post

data class PageState(
    val posts: Async<List<Post>> = Uninitialized
) : MvRxState
