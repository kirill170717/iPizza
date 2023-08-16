package com.rinnedander.data.local

import com.rinnedander.domain.model.Pizza
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface IPizzaLocalDataSource {
    fun insert(pizza: Pizza): Completable
    fun insertAll(pizzaList: List<Pizza>): Completable
    fun get(id: Int): Flowable<Pizza>
    fun getAll(): Flowable<List<Pizza>>
    fun search(query: String): Flowable<List<Pizza>>
}