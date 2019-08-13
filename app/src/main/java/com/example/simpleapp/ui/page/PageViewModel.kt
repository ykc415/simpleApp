package com.example.simpleapp.ui.page

import androidx.paging.RxPagedListBuilder
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.ViewModelContext
import com.example.simpleapp.base.MvRxViewModel
import com.example.simpleapp.data.PostDataSourceFactory
import com.example.simpleapp.util.withSnapshot
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class PageViewModel @AssistedInject constructor(
    @Assisted state: PageState,
    private val dataSourceFactory: PostDataSourceFactory
) : MvRxViewModel<PageState>(state) {


    fun fetch() {
        Timber.e("Fetch")
        setState { PageState(posts = Loading()) }

        RxPagedListBuilder(dataSourceFactory, 10).buildObservable()
            .subscribe({
                setState { PageState(posts = Success(it.withSnapshot { Timber.e(it.toString()) })) }
            }, {
                setState { PageState(posts = Fail(it)) }
            }).addTo(compositeDisposable)
    }

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