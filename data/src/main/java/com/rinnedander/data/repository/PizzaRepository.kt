package com.rinnedander.data.repository

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.remote.IPizzaRemoteDataSource
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.repository.IPizzaRepository

class PizzaRepository(
    private val local: IPizzaLocalDataSource,
    private val remote: IPizzaRemoteDataSource
) : IPizzaRepository {

    override fun get(id: Int): Flowable<Pizza> =
        local.get(id)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                this.syncPizza(id)
            }

    override fun getAll(): Flowable<List<Pizza>> =
        local.getAll()
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                this.syncPizzaList()
            }

    override fun search(query: String?): Flowable<List<Pizza>> {
        val dataFlow = if (query.isNullOrBlank()) local.getAll()
        else local.search(query)

        return dataFlow
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
    }

    private fun syncPizzaList() =
        remote.getAll()
            .subscribeOn(Schedulers.io())
            .flatMapCompletable(local::insertAll)
            .subscribe()

    private fun syncPizza(id: Int) =
        remote.get(id)
            .subscribeOn(Schedulers.io())
            .flatMapCompletable(local::insert)
            .subscribe()
}