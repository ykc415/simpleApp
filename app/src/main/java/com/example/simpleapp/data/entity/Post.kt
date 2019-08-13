package com.example.simpleapp.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

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
@Parcelize
@Entity(tableName = "posts")
data class Post @JvmOverloads constructor(

    @Json(name="id")
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int = 0,

    @Json(name="userId")
    @ColumnInfo(name = "userId") var userId: Int = 0,

    @Json(name="title")
    @ColumnInfo(name = "title") var title: String = "",

    @Json(name="body")
    @ColumnInfo(name = "body") var body: String = ""
) : Parcelable