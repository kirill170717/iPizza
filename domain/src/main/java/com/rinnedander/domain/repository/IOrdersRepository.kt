package com.rinnedander.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.domain.model.order.Order

interface IOrdersRepository {
    fun getAll(): Flowable<List<Order>>
    fun add(pizzaId: Int): Completable
    fun remove(pizzaId: Int): Completable
    fun clear(): Completable
    fun submit(): Completable
}