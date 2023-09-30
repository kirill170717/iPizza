package com.rinnedander.data.repository

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.repository.IPizzaRepository

class PizzaRepository(private val local: IPizzaLocalDataSource): IPizzaRepository {

    override fun get(id: Int): Flowable<Pizza> =
        local.get(id)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())

    override fun getAll(): Flowable<List<Pizza>> =
        local.getAll()
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())

    override fun search(query: String?): Flowable<List<Pizza>> {
        val dataFlow = if (query.isNullOrBlank()) local.getAll()
        else local.search(query)

        return dataFlow
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
    }
}