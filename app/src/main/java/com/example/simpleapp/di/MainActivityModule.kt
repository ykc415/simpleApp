package com.example.simpleapp.di

import com.example.simpleapp.ui.MainActivity
import com.example.simpleapp.ui.detail.DetailFragment
import com.example.simpleapp.ui.page.PageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindPageFragment(): PageFragment

    @ContributesAndroidInjector
    abstract fun bindDetailFragment(): DetailFragment
}
