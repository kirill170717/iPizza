package com.rinnedander.ipizza.di.modules.data.repository

import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.remote.IPizzaRemoteDataSource
import com.rinnedander.data.repository.PizzaRepository
import com.rinnedander.domain.repository.IPizzaRepository
import dagger.Module
import dagger.Provides

@Module
object PizzaRepositoryModule {

    @Provides
    fun providePizzaRepository(
        local: IPizzaLocalDataSource,
        remote: IPizzaRemoteDataSource
    ): IPizzaRepository = PizzaRepository(
        local,
        remote
    )
}