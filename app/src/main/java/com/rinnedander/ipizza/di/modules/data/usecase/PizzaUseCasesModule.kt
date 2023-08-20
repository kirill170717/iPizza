package com.rinnedander.ipizza.di.modules.data.usecase

import dagger.Module
import dagger.Provides
import com.rinnedander.domain.repository.IPizzaRepository
import com.rinnedander.domain.usecase.pizza.PizzaGet
import com.rinnedander.domain.usecase.pizza.PizzaGetAll
import com.rinnedander.domain.usecase.pizza.PizzaSearch

@Module
object PizzaUseCasesModule {

    @Provides
    fun provideGetUseCase(repository: IPizzaRepository) =
        PizzaGet(repository)

    @Provides
    fun provideGetAllUseCase(repository: IPizzaRepository) =
        PizzaGetAll(repository)

    @Provides
    fun provideSearchUseCase(repository: IPizzaRepository) =
        PizzaSearch(repository)
}