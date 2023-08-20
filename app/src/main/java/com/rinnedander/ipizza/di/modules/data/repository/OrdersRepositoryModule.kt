package com.rinnedander.ipizza.di.modules.data.repository

import dagger.Module
import dagger.Provides
import com.rinnedander.data.local.IOrdersLocalDataSource
import com.rinnedander.data.remote.IOrdersRemoteDataSource
import com.rinnedander.data.repository.OrdersRepository
import com.rinnedander.domain.repository.IOrdersRepository

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