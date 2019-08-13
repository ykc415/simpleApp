package com.example.simpleapp.data

import android.annotation.SuppressLint
import androidx.paging.ItemKeyedDataSource
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.data.remote.SimpleRemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@SuppressLint("CheckResult")
class PostDataSource @Inject constructor(
    private val remoteDataSource: SimpleRemoteDataSource
) : ItemKeyedDataSource<Int, Post>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Post>) {
        remoteDataSource.getPosts(0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { callback.onResult(it) }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Post>) {
        remoteDataSource.getPosts(params.key)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { callback.onResult(it) }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Post>) = Unit

    override fun getKey(item: Post): Int {
        return item.id
    }
}
