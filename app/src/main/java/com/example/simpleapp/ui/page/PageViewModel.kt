package com.example.simpleapp.ui.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.util.Event
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject


class PageViewModel @Inject constructor(): ViewModel() {

    private val _items = MutableLiveData<List<Post>>().apply { value = emptyList() }
    val items: LiveData<List<Post>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _openTaskEvent = MutableLiveData<Event<Int>>()
    val openTaskEvent: LiveData<Event<Int>> = _openTaskEvent
    /**
     * @param forceUpdate   Pass in true to refresh the data in the [TasksDataSource]
     */
    fun loadPosts(forceUpdate: Boolean) {
//        _dataLoading.value = true

        _items.value = listOf(Post(0, 0, "hello", "World"),
            Post(0, 0, "hello", "World"),
            Post(0, 0, "hello", "World"),
            Post(0, 0, "hello", "World"))
//        wrapEspressoIdlingResource {
//
//            viewModelScope.launch {
//                val tasksResult = tasksRepository.getTasks(forceUpdate)
//
//                if (tasksResult is Success) {
//                    val tasks = tasksResult.data
//
//                    val tasksToShow = ArrayList<Task>()
//                    // We filter the tasks based on the requestType
//                    for (task in tasks) {
//                        when (_currentFiltering) {
//                            TasksFilterType.ALL_TASKS -> tasksToShow.add(task)
//                            TasksFilterType.ACTIVE_TASKS -> if (task.isActive) {
//                                tasksToShow.add(task)
//                            }
//                            TasksFilterType.COMPLETED_TASKS -> if (task.isCompleted) {
//                                tasksToShow.add(task)
//                            }
//                        }
//                    }
//                    isDataLoadingError.value = false
//                    _items.value = ArrayList(tasksToShow)
//                } else {
//                    isDataLoadingError.value = false
//                    _items.value = emptyList()
//                    showSnackbarMessage(R.string.loading_tasks_error)
//                }
//
//                _dataLoading.value = false
//            }
//        }
    }

    fun refresh() {
        loadPosts(true)
    }

    fun openPost(id: Int) {
        _openTaskEvent.value = Event(id)
    }

}