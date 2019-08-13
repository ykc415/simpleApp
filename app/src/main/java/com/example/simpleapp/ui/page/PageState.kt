package com.example.simpleapp.ui.page

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.util.PagedListWithSnapshot

data class PageState(
    val posts: Async<PagedListWithSnapshot<Post>> = Uninitialized
) : MvRxState
