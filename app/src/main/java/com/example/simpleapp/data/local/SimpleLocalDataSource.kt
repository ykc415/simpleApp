package com.example.simpleapp.data.local

import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post
import io.reactivex.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SimpleLocalDataSource internal constructor(
    private val postDao: PostDao,
    private val commentDao: CommentDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    fun getPosts(start: Int) = postDao.dataSource

    fun getComments(postId: Int): Single<List<Comment>> {
        return Single.just(commentDao.all(postId))
    }

    fun deletePost(post: Post) {
        postDao.delete(post)
    }

    fun patchPost(post: Post) {
        postDao.update(post)
    }

}