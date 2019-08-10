package com.example.simpleapp.di

import androidx.lifecycle.ViewModel
import com.example.simpleapp.ui.page.PageFragment
import com.example.simpleapp.ui.page.PageViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PageModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun pageFragment(): PageFragment

    @Binds
    @IntoMap
    @ViewModelKey(PageViewModel::class)
    abstract fun bindViewModel(viewModel: PageViewModel): ViewModel
}