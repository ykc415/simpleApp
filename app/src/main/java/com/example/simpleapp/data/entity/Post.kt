package com.example.simpleapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *      Raw Json
 *
        {
            "userId": 1,
            "id": 1,
            "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        }

 */
@Entity(tableName = "posts")
data class Post @JvmOverloads constructor(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "userId") var userId: Int = 0,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "body") var body: String = ""
)