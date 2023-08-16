package com.rinnedander.domain.repository

import com.rinnedander.domain.model.Pizza
import io.reactivex.rxjava3.core.Flowable

interface IPizzaRepository {
    fun get(id: Int): Flowable<Pizza>
    fun getAll(): Flowable<List<Pizza>>
    fun search(query: String?): Flowable<List<Pizza>>
}