package com.example.simpleapp.data

import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.di.ApplicationModule.LocalDataSource
import com.example.simpleapp.di.ApplicationModule.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    @RemoteDataSource private val remoteDataSource: DataSource,
    @LocalDataSource private val localDataSource: DataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : Repository {

    override suspend fun getPosts(): Result<List<Post>> {
        return withContext(ioDispatcher) {
            remoteDataSource.getPosts()
        }

    }

    override suspend fun getPostDetail() {
    }

    override suspend fun editPost(title: String?, body: String?) {
    }

    override suspend fun deletePost() {
    }
}