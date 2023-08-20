package com.rinnedander.data.remote

import io.reactivex.rxjava3.core.Completable
import com.rinnedander.domain.model.order.Order

interface IOrdersRemoteDataSource {
    fun submit(orders: List<Order>): Completable
}