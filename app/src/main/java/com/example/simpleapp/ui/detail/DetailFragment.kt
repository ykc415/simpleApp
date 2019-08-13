package com.example.simpleapp.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.simpleapp.R
import com.example.simpleapp.base.BaseFragment
import com.example.simpleapp.databinding.FragmentPageBinding
import com.example.simpleapp.util.toast
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.dialog_edit.view.*
import kotlinx.android.synthetic.main.fragment_page.*
import timber.log.Timber
import javax.inject.Inject

class DetailFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: DetailViewModel.Factory

    private val viewModel: DetailViewModel by fragmentViewModel()

    private lateinit var viewDataBinding: FragmentPageBinding


    private val controller = DetailController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentPageBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return viewDataBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.setController(controller)

        viewModel.patch()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun invalidate()  = withState(viewModel) { state ->
        Timber.e("$state")
        if (state.post == null) {
            progress.hide()
            toast("deleted")
            activity?.onBackPressed()
        }

        when (state.comments) {
            Uninitialized -> Unit
            is Success -> {
                progress.hide()
                val comments = state.comments()
                controller.setData(state.post, comments)
            }
            is Loading -> progress.show()
            is Error -> { toast(state.comments.message ?: "error") }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_delete -> {
                showDeleteDialog()
                true
            }
            R.id.menu_edit -> {
                showEditDialog()
                true
            }
            else -> false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_fragment_menu, menu)
    }

    private fun showDeleteDialog() {
        MaterialDialog(context!!).show {
            title(text = "Are you sure want to delete?")
            cancelable(true)
            positiveButton(text = "Agree") {
                viewModel.delete()
            }
            negativeButton(text = "Disagree")
        }
    }

    private fun showEditDialog() {
        MaterialDialog(context!!).show {
            cancelable(true)

            customView(R.layout.dialog_edit, scrollable = true)

            getCustomView().apply {
                withState(viewModel) {
                    title.setText(it.post!!.title)
                    body.setText(it.post.body)
                }
             }

            positiveButton(text = "OK") {
                viewModel.edit(getCustomView().title.text.toString(), getCustomView().body.text.toString())
            }
            negativeButton(text = "CANCEL")
        }
    }

}