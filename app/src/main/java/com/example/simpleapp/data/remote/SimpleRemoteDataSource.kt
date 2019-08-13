package com.example.simpleapp.data.remote

import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post
import io.reactivex.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SimpleRemoteDataSource(
    val simpleApi: SimpleApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

) {

    fun getPosts(start: Int): Single<List<Post>> {
        return simpleApi.getPosts(start, LIMIT)
    }

    fun getPost(postId: Int): Single<Post> {
        return simpleApi.getPost(postId)
    }

    fun getComments(postId: Int): Single<List<Comment>> {
        return simpleApi.getComments(postId)
    }

    fun deletePost(postId: Int): Single<Post> {
        return simpleApi.deletePost(postId)
    }

    fun patchPost(post: Post): Single<Post> {
        return simpleApi.patchPost(post.id, post)
    }

    companion object {
        const val LIMIT = 10
    }

}