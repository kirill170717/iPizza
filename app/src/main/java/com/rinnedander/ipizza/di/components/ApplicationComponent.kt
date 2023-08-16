package com.rinnedander.ipizza.di.components

import com.rinnedander.ipizza.ui.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<Application> {

    override fun inject(instance: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(instance: Application): Builder

        fun build(): ApplicationComponent
    }
}