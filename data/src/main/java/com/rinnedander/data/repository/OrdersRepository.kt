package com.rinnedander.data.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.rinnedander.data.local.IOrdersLocalDataSource
import com.rinnedander.data.remote.IOrdersRemoteDataSource
import com.rinnedander.domain.model.order.Order
import com.rinnedander.domain.repository.IOrdersRepository

class OrdersRepository(
    private val local: IOrdersLocalDataSource,
    private val remote: IOrdersRemoteDataSource
) : IOrdersRepository {

    override fun getAll(): Flowable<List<Order>> =
        local.getAll()
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())

    override fun add(pizzaId: Int): Completable =
        local.add(pizzaId)
            .subscribeOn(Schedulers.io())

    override fun remove(pizzaId: Int): Completable =
        local.remove(pizzaId)
            .subscribeOn(Schedulers.io())

    override fun clear(): Completable =
        local.clear()
            .subscribeOn(Schedulers.io())

    override fun submit(): Completable =
        local.getAll()
            .subscribeOn(Schedulers.io())
            .firstOrError()
            .flatMapCompletable(remote::submit)
            .andThen(clear())
}