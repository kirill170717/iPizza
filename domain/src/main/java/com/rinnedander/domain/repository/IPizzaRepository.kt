package com.rinnedander.domain.repository

import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.domain.model.Pizza

interface IPizzaRepository {
    fun get(id: Int): Flowable<Pizza>
    fun getAll(): Flowable<List<Pizza>>
    fun search(query: String?): Flowable<List<Pizza>>
}