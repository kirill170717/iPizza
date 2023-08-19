package com.rinnedander.ipizza.di.modules.ui.activities

import com.rinnedander.ipizza.ui.activities.MainActivity
import com.rinnedander.ipizza.di.modules.data.repository.OrdersRepositoryModule
import com.rinnedander.ipizza.di.modules.data.repository.PizzaRepositoryModule
import com.rinnedander.ipizza.di.modules.data.source.OrdersDataSourceModule
import com.rinnedander.ipizza.di.modules.data.source.PizzaDataSourceModule
import com.rinnedander.ipizza.di.modules.data.usecase.OrderUseCasesModule
import com.rinnedander.ipizza.di.modules.data.usecase.PizzaUseCasesModule
import com.rinnedander.ipizza.di.modules.ui.dialogs.DialogsModule
import com.rinnedander.ipizza.di.modules.ui.fragments.FragmentsModule
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentsModule::class,
            DialogsModule::class,
            ViewModelModule::class,
            OrderUseCasesModule::class,
            OrdersRepositoryModule::class,
            OrdersDataSourceModule::class,
            PizzaUseCasesModule::class,
            PizzaRepositoryModule::class,
            PizzaDataSourceModule::class
        ]
    )
    fun mainActivity(): MainActivity
}