package com.example.simpleapp.di

import androidx.lifecycle.ViewModel
import com.example.simpleapp.ui.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DetailModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun detailFragment(): DetailViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindViewModel(viewModel: DetailViewModel): ViewModel
}