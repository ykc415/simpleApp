package com.example.simpleapp.data

interface Repository {

    suspend fun getPost()

    suspend fun getPostDetail()

    suspend fun editPost(title: String?, body: String?)

    suspend fun deletePost()

}