package com.example.simpleapp.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewModelStore
import dagger.android.support.DaggerFragment
import java.util.UUID
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment(), MvRxView {

    /**
     * This is to force Dagger to create an injector in this module. Otherwise all of the
     * dependent modules create one, which leads to duplicate classes, which breaks R8.
     */
    @Suppress("unused")
    @Inject
    lateinit var _dummyTiviMvRxFragment: Context

    override val mvrxViewModelStore by lazy { MvRxViewModelStore(viewModelStore) }

    final override val mvrxViewId
        get() = mvrxPersistedViewId

    private lateinit var mvrxPersistedViewId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        mvrxViewModelStore.restoreViewModels(this, savedInstanceState)
        mvrxPersistedViewId = savedInstanceState?.getString(PERSISTED_VIEW_ID_KEY)
            ?: "${this::class.java.simpleName}_${UUID.randomUUID()}"

        super.onCreate(savedInstanceState)
    }

    /**
     * Fragments should override the subscriptionLifecycle owner so that subscriptions made after onCreate
     * are properly disposed as fragments are moved from/to the backstack.
     */
    override val subscriptionLifecycleOwner: LifecycleOwner
        get() = viewLifecycleOwnerLiveData.value ?: this

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mvrxViewModelStore.saveViewModels(outState)
        outState.putString(PERSISTED_VIEW_ID_KEY, mvrxViewId)
    }

    override fun onStart() {
        super.onStart()
        // This ensures that invalidate() is called for static screens that don't
        // subscribe to a ViewModel.
        postInvalidate()
    }

    companion object {
        private const val PERSISTED_VIEW_ID_KEY = "mvrx:persisted_view_id"
    }
}