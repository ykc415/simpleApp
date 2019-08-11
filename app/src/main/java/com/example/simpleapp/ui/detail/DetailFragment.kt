package com.example.simpleapp.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.fragmentViewModel
import com.example.simpleapp.R
import com.example.simpleapp.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: DetailViewModel.Factory

    private val viewModel: DetailViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_default, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupListAdapter()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun setupListAdapter() {

    }

    override fun invalidate() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            else -> false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.taskdetail_fragment_menu, menu)
    }

    companion object {
        fun newInstance(userId: Long): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MvRx.KEY_ARG, null)
                }
            }
    }

}