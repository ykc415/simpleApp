package com.example.simpleapp.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simpleapp.R
import com.example.simpleapp.databinding.FragmentPageBinding
import com.example.simpleapp.util.toast
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PageFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewDataBinding: FragmentPageBinding
    private lateinit var listAdapter: PostsAdapter


    private val viewModel by viewModels<PageViewModel> { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentPageBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListAdapter()


        // Always reloading data for simplicity. Real apps should only do this on first load and
        // when navigating back to this destination. TODO: https://issuetracker.google.com/79672220
        viewModel.loadPosts(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_clear -> {
                toast("HI")
                true
            }
            R.id.menu_refresh -> {
                toast("gg")
                true
            }
            else -> false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    private fun openPostDetail(postId: Int) {
        val action = PageFragmentDirections.actionPageToDetail(postId)
        findNavController().navigate(action)
    }

    private fun setupListAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            listAdapter = PostsAdapter(viewModel)
            viewDataBinding.postsList.adapter = listAdapter
        }
    }

}