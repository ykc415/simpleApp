package com.example.simpleapp.data.local

import com.example.simpleapp.data.DataSource
import com.example.simpleapp.data.Result
import com.example.simpleapp.data.entity.Post
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SimpleLocalDataSource internal constructor(
    private val postDao: PostDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DataSource {
    override fun getPosts(): Result<List<Post>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}