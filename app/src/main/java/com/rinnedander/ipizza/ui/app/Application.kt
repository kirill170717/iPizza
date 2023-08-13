package com.rinnedander.ipizza.ui.app

import com.rinnedander.ipizza.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        this.observeUncaughtErrors()
    }

    private fun observeUncaughtErrors() {
        RxJavaPlugins.setErrorHandler { throwable ->
            throwable.printStackTrace()
        }
    }
}