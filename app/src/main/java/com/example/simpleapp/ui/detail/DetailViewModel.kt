package com.example.simpleapp.ui.detail

import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.ViewModelContext
import com.example.simpleapp.base.MvRxViewModel
import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.data.remote.SimpleApi
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class DetailViewModel @AssistedInject constructor(
    @Assisted state: DetailState,
    private val simpleApi: SimpleApi
): MvRxViewModel<DetailState>(state) {

    fun patch() {
        setState { copy(comments = Loading()) }

        withState { state ->
            simpleApi.getComments(state.post!!.id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setState { copy(post = post, comments = Success(it)) }
                }, {
                    setState { copy(comments = Fail(it)) }
                }).addTo(compositeDisposable)
        }
    }

    fun delete() {
        setState { copy(comments = Loading()) }

        withState {
            simpleApi.deletePost(it.post!!.id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setState { copy(post = null) }
                }, {
                    setState { copy(comments = Fail(DeleteFailException())) }
                })
        }
    }

    fun edit(title: String, body: String) {
        var temp: List<Comment>? = null

        setState {
            temp = this.comments()!!
            copy(comments = Loading())
        }

        withState {
            simpleApi.patchPost(it.post!!.id, it.post.copy(title = title, body = body))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setState { copy(post = it, comments = Success(temp!!)) }
                }, {
                    setState { copy(comments = Fail(EditFailException())) }
                })
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: DetailState): DetailViewModel
    }

    companion object : MvRxViewModelFactory<DetailViewModel, DetailState> {
        override fun create(viewModelContext: ViewModelContext, state: DetailState): DetailViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<DetailFragment>()

            val post = fragment.arguments!!.get("post") as Post

            return fragment.viewModelFactory.create(state.copy(post = post))
        }
    }
}