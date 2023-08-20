package com.rinnedander.data.remote.data

import io.reactivex.rxjava3.core.Completable
import com.rinnedander.data.remote.IOrdersRemoteDataSource
import com.rinnedander.data.remote.bodies.order.OrderBody
import com.rinnedander.data.remote.client.order.IOrderClient
import com.rinnedander.domain.model.order.Order

class OrdersRemoteDataSource(
    private val client: IOrderClient
) : IOrdersRemoteDataSource {

    override fun submit(orders: List<Order>): Completable =
        orders.map(OrderBody.Companion::fromOrder)
            .let(client::placeOrder)
}