package com.example.simpleapp.ui.page

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.simpleapp.base.MvRxViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PageViewModel @AssistedInject constructor(
    @Assisted state: PageState
): MvRxViewModel<PageState>(state) {

    @AssistedInject.Factory
    interface Factory {
        fun create(state: PageState): PageViewModel
    }

    companion object : MvRxViewModelFactory<PageViewModel, PageState> {
        override fun create(viewModelContext: ViewModelContext, state: PageState): PageViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<PageFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }

}