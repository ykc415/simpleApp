package com.example.simpleapp.data

import com.example.simpleapp.data.entity.Post

interface DataSource {

    fun getPosts(): Result<List<Post>>

}