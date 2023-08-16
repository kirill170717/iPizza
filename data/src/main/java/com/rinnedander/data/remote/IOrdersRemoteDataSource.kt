package com.rinnedander.data.remote

import com.rinnedander.domain.model.order.Order
import io.reactivex.rxjava3.core.Completable

interface IOrdersRemoteDataSource {
    fun submit(orders: List<Order>): Completable
}