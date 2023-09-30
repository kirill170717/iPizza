package com.rinnedander.ipizza.di.modules.data.repository

import dagger.Module
import dagger.Provides
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.repository.PizzaRepository
import com.rinnedander.domain.repository.IPizzaRepository

@Module
object PizzaRepositoryModule {

    @Provides
    fun providePizzaRepository(local: IPizzaLocalDataSource): IPizzaRepository = PizzaRepository(local)
}