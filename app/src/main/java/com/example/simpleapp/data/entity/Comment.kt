package com.example.simpleapp.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 *      Raw Json

{
    "postId": 1,
    "id": 1,
    "name": "id labore ex et quam laborum",
    "email": "Eliseo@gardner.biz",
    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
}
 */
@Parcelize
@Entity(
    tableName = "comments"
)
data class Comment @JvmOverloads constructor(

    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int = 0,

    @Json(name = "postId")
    @ColumnInfo(name = "postId") var postId: Int = 0,

    @Json(name = "name")
    @ColumnInfo(name = "name") var name: String = "",

    @Json(name = "email")
    @ColumnInfo(name = "email") var email: String = "",

    @Json(name = "body")
    @ColumnInfo(name = "body") var body: String = ""
) : Parcelable