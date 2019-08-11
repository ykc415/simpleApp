package com.example.simpleapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.entity.Post
import javax.inject.Inject

class DetailViewModel @Inject constructor(): ViewModel() {


    private val _items = MutableLiveData<List<Post>>().apply { value = emptyList() }
    val items: LiveData<List<Post>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    
    fun start(id: Int) {

    }


    fun loadPosts(forceUpdate: Boolean) {
    }

    fun refresh() {
        loadPosts(true)
    }
}