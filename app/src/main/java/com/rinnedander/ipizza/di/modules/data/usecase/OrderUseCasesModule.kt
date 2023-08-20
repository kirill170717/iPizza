package com.rinnedander.ipizza.di.modules.data.usecase

import dagger.Module
import dagger.Provides
import com.rinnedander.domain.repository.IOrdersRepository
import com.rinnedander.domain.usecase.order.*

@Module
object OrderUseCasesModule {

    @Provides
    fun provideAddUseCase(repository: IOrdersRepository) =
        OrderAdd(repository)

    @Provides
    fun provideClearUseCase(repository: IOrdersRepository) =
        OrderClear(repository)

    @Provides
    fun provideGetAllUseCase(repository: IOrdersRepository) =
        OrderGetAll(repository)

    @Provides
    fun provideRemoveUseCase(repository: IOrdersRepository) =
        OrderRemove(repository)

    @Provides
    fun provideSubmitUseCase(repository: IOrdersRepository) =
        OrderSubmit(repository)

    @Provides
    fun provideGetTotalUseCase(orderGetAll: OrderGetAll) =
        OrderGetTotal(orderGetAll)

    @Provides
    fun provideGetWithTotalUseCase(orderGetAll: OrderGetAll) =
        OrderGetWithTotal(orderGetAll)
}