package com.example.simpleapp.ui.detail

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.simpleapp.base.MvRxViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted state: DetailState
): MvRxViewModel<DetailState>(state) {




    @AssistedInject.Factory
    interface Factory {
        fun create(state: DetailState): DetailViewModel
    }

    companion object : MvRxViewModelFactory<DetailViewModel, DetailState> {
        override fun create(viewModelContext: ViewModelContext, state: DetailState): DetailViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<DetailFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}