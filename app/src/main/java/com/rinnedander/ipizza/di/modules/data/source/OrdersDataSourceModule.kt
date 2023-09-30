package com.rinnedander.ipizza.di.modules.data.source

import dagger.Module
import dagger.Provides
import com.rinnedander.data.local.IOrdersLocalDataSource
import com.rinnedander.data.local.data.OrdersLocalDataSource
import com.rinnedander.data.local.database.dao.IOrdersDao

@Module
object OrdersDataSourceModule {

    @Provides
    fun provideLocalDataSource(dao: IOrdersDao): IOrdersLocalDataSource =
        OrdersLocalDataSource(dao)
}