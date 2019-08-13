package com.example.simpleapp.base

import android.content.Context
import com.airbnb.mvrx.BaseMvRxFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragment : BaseMvRxFragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun onAttach(context: Context) {
        Timber.e("onAttach")

        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> {
        return androidInjector
    }

}