package com.example.simpleapp.data.local

import androidx.room.Dao
import androidx.room.Query
import com.example.simpleapp.data.entity.Comment

@Dao
interface CommentDao {

    @Query("SELECT * FROM comments WHERE postId = :id")
    fun all(id: Int): List<Comment>

}