package com.rinnedander.ipizza.di.components

import javax.inject.Singleton
import dagger.Component
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.rinnedander.ipizza.ui.app.Application
import com.rinnedander.ipizza.di.modules.data.source.core.local.PrimaryDatabaseModule
import com.rinnedander.ipizza.di.modules.ui.activities.ActivitiesModule
import com.rinnedander.ipizza.di.modules.ui.application.ApplicationModule

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivitiesModule::class,
        PrimaryDatabaseModule::class
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