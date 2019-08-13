package com.example.simpleapp.data

import androidx.paging.DataSource
import com.example.simpleapp.data.entity.Post
import javax.inject.Inject

class PostDataSourceFactory @Inject constructor(
    private val dataSource: PostDataSource
) : DataSource.Factory<Int, Post>() {
    override fun create(): DataSource<Int, Post> {
        return dataSource
    }
}