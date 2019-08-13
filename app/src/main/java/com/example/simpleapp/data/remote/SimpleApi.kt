package com.example.simpleapp.data.remote

import com.example.simpleapp.data.entity.Comment
import com.example.simpleapp.data.entity.Post
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("/posts")
    fun getPosts(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int
    ): Single<List<Post>>

    @GET("/post/{id}")
    fun getPost(
        @Path("id") id: Int
    ): Single<Post>

    @GET("/posts/{id}/comments")
    fun getComments(
        @Path("id") id: Int
    ): Single<List<Comment>>

    @DELETE("/posts/{id}")
    fun deletePost(
        @Path("id") id: Int
    ): Single<Post>

    @PATCH("/posts/{id}")
    fun patchPost(
        @Path("id") id: Int,
        @Body post: Post
    ): Single<Post>

}