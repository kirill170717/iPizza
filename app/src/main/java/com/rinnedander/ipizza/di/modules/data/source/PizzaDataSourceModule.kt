package com.rinnedander.ipizza.di.modules.data.source

import dagger.Module
import dagger.Provides
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.local.data.PizzaLocalDataSource
import com.rinnedander.data.local.database.dao.IPizzaDao
import com.rinnedander.data.remote.IPizzaRemoteDataSource
import com.rinnedander.data.remote.client.pizza.IPizzaClient
import com.rinnedander.data.remote.data.PizzaRemoteDataSource

@Module
object PizzaDataSourceModule {

    @Provides
    fun provideLocalDataSource(dao: IPizzaDao): IPizzaLocalDataSource =
        PizzaLocalDataSource(dao)

    @Provides
    fun provideRemoteDataSource(client: IPizzaClient): IPizzaRemoteDataSource =
        PizzaRemoteDataSource(client)
}