package com.example.simpleapp.di

import android.content.Context
import com.example.simpleapp.SimpleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        AppAssistedModule::class,
        MainActivityModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<SimpleApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}