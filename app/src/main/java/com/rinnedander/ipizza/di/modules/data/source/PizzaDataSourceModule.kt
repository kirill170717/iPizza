package com.rinnedander.ipizza.di.modules.data.source

import dagger.Module
import dagger.Provides
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.local.data.PizzaLocalDataSource
import com.rinnedander.data.local.database.dao.IPizzaDao

@Module
object PizzaDataSourceModule {

    @Provides
    fun provideLocalDataSource(dao: IPizzaDao): IPizzaLocalDataSource =
        PizzaLocalDataSource(dao)
}