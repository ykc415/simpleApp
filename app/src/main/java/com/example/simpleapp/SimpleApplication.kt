package com.example.simpleapp

import com.appspector.sdk.AppSpector
import com.example.simpleapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree

open class SimpleApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())

            AppSpector
                .build(this)
                .addPerformanceMonitor()
                .addHttpMonitor()
                .addLogMonitor()
                .addScreenshotMonitor()
                .addSQLMonitor()
                .run("android_YmRmODAxNDMtMTRiNi00OGIyLWIzZmItNTBkMTQwMmMwMGFh")
        }
    }
}
