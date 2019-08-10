package com.example.simpleapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simpleapp.data.entity.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class SimpleDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao
}