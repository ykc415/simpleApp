package com.example.simpleapp.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.simpleapp.R
import com.example.simpleapp.base.BaseFragment
import com.example.simpleapp.data.entity.Post
import com.example.simpleapp.databinding.FragmentPageBinding
import com.example.simpleapp.util.toast
import kotlinx.android.synthetic.main.fragment_page.*
import timber.log.Timber
import javax.inject.Inject

class PageFragment : BaseFragment(), PageController.PostCallback {

    @Inject
    lateinit var viewModelFactory: PageViewModel.Factory

    private val viewModel: PageViewModel by fragmentViewModel()

    private lateinit var viewDataBinding: FragmentPageBinding

    lateinit var pageController: PageController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentPageBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pageController = PageController(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = pageController.adapter

        viewModel.fetch()

    }

    override fun onPostClick(post: Post) {
        openPostDetail(post)
    }

    override fun invalidate() = withState(viewModel) { state ->
        Timber.e(state.posts.toString())
        when (state.posts) {
            Uninitialized -> Unit
            is Success -> {
                progress.hide()
                pageController.submitList(state.posts()?.pagedList)
            }
            is Loading -> progress.show()
            is Error -> { toast(state.posts.message ?: "error") }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                toast("Hello")
                true
            }
            else -> false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.page_fragment_menu, menu)
    }

    private fun openPostDetail(post: Post) {

        val action = PageFragmentDirections.actionPageToDetail(post)
        findNavController().navigate(action)
    }

}

