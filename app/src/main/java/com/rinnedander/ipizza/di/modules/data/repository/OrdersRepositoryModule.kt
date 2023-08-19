package com.rinnedander.ipizza.di.modules.data.repository

import com.rinnedander.data.local.IOrdersLocalDataSource
import com.rinnedander.data.remote.IOrdersRemoteDataSource
import com.rinnedander.data.repository.OrdersRepository
import com.rinnedander.domain.repository.IOrdersRepository
import dagger.Module
import dagger.Provides

@Module
object OrdersRepositoryModule {

    @Provides
    fun provideOrdersRepository(
        local: IOrdersLocalDataSource,
        remote: IOrdersRemoteDataSource
    ): IOrdersRepository = OrdersRepository(
        local,
        remote
    )
}