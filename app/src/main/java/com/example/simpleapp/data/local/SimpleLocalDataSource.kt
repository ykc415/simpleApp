package com.example.simpleapp.data.local

import com.example.simpleapp.data.DataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SimpleLocalDataSource internal constructor(
    private val postDao: PostDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DataSource {


}