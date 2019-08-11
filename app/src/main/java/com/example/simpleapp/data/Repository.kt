package com.example.simpleapp.data

import com.example.simpleapp.data.entity.Post

interface Repository {

    suspend fun getPosts(): Result<List<Post>>

    suspend fun getPostDetail()

    suspend fun editPost(title: String?, body: String?)

    suspend fun deletePost()

}