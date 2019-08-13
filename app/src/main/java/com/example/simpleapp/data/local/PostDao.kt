package com.example.simpleapp.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.simpleapp.data.entity.Post

@Dao
interface PostDao {
    @get:Query("SELECT * FROM posts")
    val dataSource: DataSource.Factory<Int, Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<Post>)

    @Delete
    fun delete(post: Post)

    @Update
    fun update(post: Post)
}