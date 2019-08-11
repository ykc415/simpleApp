package com.example.simpleapp.ui.page

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.fragmentViewModel
import com.example.simpleapp.R
import com.example.simpleapp.base.BaseFragment
import com.example.simpleapp.util.toast
import javax.inject.Inject
import dagger.android.support.AndroidSupportInjection


class PageFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: PageViewModel.Factory

    private val viewModel: PageViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_default, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListAdapter()
    }

    override fun invalidate() {

    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
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

    }

    companion object {
        fun newInstance(userId: Long): PageFragment =
            PageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MvRx.KEY_ARG, null)
                }
            }
    }

}